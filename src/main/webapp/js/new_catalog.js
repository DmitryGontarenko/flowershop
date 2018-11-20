$(document).ready(function () {

    var $addCartItemButton = $('[role=addCartItem]');
    var $removeCartItemButtons = $('[role=removeCartItem]');
    var $removeAllItemsButtons = $('[role=removeAllCartItems]');
    var $orderProductsCartBody = $('table#orderProductsCart').find('tbody');

    function refreshCartFields(data) {
        // отображение в шапке (catalog)
        $('.cart-quantity').html(data.itemCount);
        $('.cart-total').each(function () {
            $(this).html(data.total);
        });

        // отображение в корзине (cart)
        $orderProductsCartBody.find('tr').each(function (index) {
            var findFlag = false;
            for(var i = 0; i < data.itemList.length; i++) {
                if($(this).data("id") == data.itemList[i].product.id) {
                    $(this).find('.ciQuantity').html(data.itemList[i].quantity);
                    $(this).find('.ciTotalRub').html('<del>' + data.itemList[i].cartItemTotal + '</del>');
                    $(this).find('.ciTotalDiscount').html(data.itemList[i].cartItemTotalDiscount);
                    findFlag = true;
                    break;
                }
            }
            // Если совпадения не найдено, то удаляем строку
            if(!findFlag) $(this).remove();
        });
    }

    $addCartItemButton.each(function () {
        var productId = $(this).attr('data-id');
        $(this).on('click', function () {
            $.ajax({
                type: "POST",
                url: '/rest/shoppingcart/add',
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify({productId: productId}),
                dataType: "json",

            }).done(function (data) {
                refreshCartFields.call(this, data);
            })
        });
    })

    $removeCartItemButtons.each(function () {
        var productId = $(this).attr('data-id');
        $(this).on('click', function () {
            $.ajax({
                type: "POST",
                url: '/rest/shoppingcart/remove',
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify({productId: productId}),
                dataType: "json",

            }).done(function (data) {
                refreshCartFields.call(this, data);
            })
        });
    })

    $removeAllItemsButtons.each(function () {
        $(this).on('click', function () {
            $.ajax({
                type: "GET",
                url: '/rest/shoppingcart/removeall',
                contentType: "application/json; charset=utf-8",
                dataType: "json",

            }).done(function (data) {
                $('.cart-quantity').html(data.itemCount);
                $('.cart-total').each(function () {
                    $(this).html(data.total);
                });
                $orderProductsCartBody.empty();
            })
        })
    })

})