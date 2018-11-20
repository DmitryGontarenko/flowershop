var catalog = {}; // массив товаров (local storage)

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
                if (catalog[productId] != undefined) {
                    catalog[productId]++;
                }
                else {
                    catalog[productId] = 1;
                }
                // JSON.stringify - преобразует в строку
                localStorage.setItem('catalog', JSON.stringify(catalog))
                console.log(catalog)
                shopMiniCart(); // показать корзину (отрисовать заного при добавлении нового товара)
            })
        })
    }

    // проверка наличие корзины в localStorage;
    function checkCart() {
        // если в localStorage что то есть
        if (localStorage.getItem('catalog') != null) {
            // присвоить массиву (корзине) то, что вытащу из localStorage и преобразовать из строки в массив
            catalog = JSON.parse(localStorage.get('catalog'));
        }
    }

    // показывает содержимое корзины
    function shopMiniCart() {
        var out = '';
        for (var w in catalog) {
            out += w + '---' + catalog[w] + '<br>';
        }
        $('#mini-catalog').html(out);
    }


