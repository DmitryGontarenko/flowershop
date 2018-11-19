var cart = {}; // массив товаров (local storage)

$(document).ready(function () {
    addToCart();
    checkCart(); // проверка наличии корзины
    shopMiniCart(); // показать корзину
});

    function addToCart() {
        var $addCartItemButtons = $('[role=addCartItem]');
        $addCartItemButtons.each(function () {
            var productId = $(this).attr('data-id');
            $(this).on('click', function () {
                // если товар уже лежит в корзине, увеличиваем его кол-во
                if (cart[productId] != undefined) {
                    cart[productId]++;
                }
                else {
                    cart[productId] = 1;
                }
                // JSON.stringify - преобразует в строку
                localStorage.setItem('cart', JSON.stringify(cart))
                console.log(cart)
                shopMiniCart(); // показать корзину (отрисовать заного при добавлении нового товара)
            })
        })
    }

    // проверка наличие корзины в localStorage;
    function checkCart() {
        // если в localStorage что то есть
        if (localStorage.getItem('cart') != null) {
            // присвоить массиву (корзине) то, что вытащу из localStorage и преобразовать из строки в массив
            cart = JSON.parse(localStorage.get('cart'));
        }
    }

    // показывает содержимое корзины 
    function shopMiniCart() {
        var out = '';
        for (var w in cart) {
            out += w + '---' + cart[w] + '<br>';
        }
        $('#mini-cart').html(out);
    }


