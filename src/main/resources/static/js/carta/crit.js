//PARA EL CARRO

const btnCarro = document.querySelector('.btn-Carro')
const carro = document.querySelector('.carro')
const btnClose = document.querySelector('#carro-close')

btnCarro.addEventListener('click', () => {
    carro.classList.add('carro-active');
});

btnClose.addEventListener('click', () => {
    carro.classList.remove('carro-active');
});

document.addEventListener('DOMContentLoaded', loadComida);

function loadComida() {
    loadContent();
}

function loadContent() {
    let btnRemove = document.querySelectorAll('.carro-remove');
    console.log(btnRemove);
    btnRemove.forEach((btn) => {
        btn.addEventListener('click', removeItem);
    });

    let qtyElements = document.querySelectorAll('.carro-cantidad');
    qtyElements.forEach((input) => {
        input.addEventListener('change', changeQty);
    });

    let cartBtns = document.querySelectorAll('.add-Carro');
    cartBtns.forEach((btn) => {
        btn.addEventListener('click', addCart);
    });
    updateTotal();
}

function removeItem() {
    if (confirm('Estas seguro que quieres eliminar el platillo')) {
        let title = this.parentElement.querySelector('.carro-food-title').innerHTML;
        itemList = itemList.filter(el => el.title != title);
        this.parentElement.remove();
        loadContent();

    }
}

function changeQty() {
    if (isNaN(this.value) || this.value < 1) {
        this.value = 1;
    }
    loadContent();
}

let itemList = [];

function addCart() {
    let food = this.parentElement;
    let idpro = food.querySelector('.comida-idpro').innerHTML;
    let title = food.querySelector('.comida-titulo').innerHTML;
    let price = food.querySelector('.comida-precio').innerHTML;
    let imgSrc = this.parentElement.querySelector('.img-comida').src;

    let newProduct = {idpro, title, price, imgSrc}

    if (itemList.find((el) => el.title == newProduct.title)) {
        alert("Este platillo ya esta en el carrito");
        return;
    } else {
        itemList.push(newProduct);
    }

    let newProductElement = createCartProduct(idpro, title, price, imgSrc);
    let element = document.createElement('div');
    element.innerHTML = newProductElement;
    let cartBasket = document.querySelector('.carro-contenido');
    cartBasket.append(element);
    loadContent();
}

function createCartProduct(idpro, title, price, imgSrc) {
    return`
    <div class="carro-box">
       <img src="${imgSrc}" class="carro-img">
       <div class="detalle-box">
        <div class="carro-food-title">${title}</div>
        <div class="precio-box">
              <div class="carro-idpro"> ${idpro}</div>
              <div class="carro-precio"> ${price}</div>
              <div class="carro-amt"> ${price} </div>
          </div>
              <input type="number" value="1" class="carro-cantidad">
        </div>
        <i class="fa fa-trash carro-remove"></i>
    </div>
    `;
}

function updateTotal() {
    const cartItems = document.querySelectorAll('.carro-box');
    const totalValue = document.querySelector('.total-precio');

    let total = 0;
    cartItems.forEach(product => {
        let priceElement = product.querySelector('.carro-precio');
        let price = parseFloat(priceElement.innerHTML.replace("S/", ""));
        let qty = product.querySelector('.carro-cantidad').value;
        total += (price * qty);
        product.querySelector('.carro-amt').innerText = "S/" + (price * qty);
    });
    totalValue.innerHTML = 'S/' + total;

    const cartCount = document.querySelector('.carro-count');
    let count = itemList.length;
    cartCount.innerHTML = count;

    if (count == 0) {
        cartCount.style.display = 'none';
    } else {
        cartCount.style.display = 'block';
    }
}

function valores() {
    
    const cartItems = document.querySelectorAll('.carro-box');
    const totalValue = document.querySelector('.total-precio');
    
    let totalpro = 0;
    cartItems.forEach(product => {
        let price = product.querySelector('.carro-precio');
        let price = parseFloat(priceElement.innerHTML.replace("S/", ""));
        let can = product.querySelector('.carro-cantidad').value;
        
        let total = (price * can);
    });
    totalValue.innerHTML = 'S/' + totalpro;
    
}


//$(document).on("click", ".btn-comprar", () => {
//
//    $.ajax({
//        type: 'POST',
//        data: {
//            itemList,
//            $("#nomapecli").val(),
//            $("#dnicli").val()
//        },
//        datatype:"json",
//        url: '/CartaSw',
//        success: function (resultado) {
//            //
//        }
//    });
//
//})


