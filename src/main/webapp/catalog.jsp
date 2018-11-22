 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="w" tagdir="/WEB-INF/tags" %>

 <w:wrapper>
     <form method="get" action="/catalog">
         <input type="text" name="productName" id="productName" placeholder="Поиск">
         <button type="submit">Поиск</button>
     </form>

     <%--ВЫВОД СПИСКА ТОВАРОВ--%>
     <div class="CartGoods">
         <c:forEach var="product" items="${productlist}">
             <table  class="tstyle">
                 <tr><h3>${product.name}</h3></tr>
                 <tr>
                     <td>Цена: ${product.price}</td>
                     <td>В наличии: ${product.inStock}</td>
                 </tr>
             </table>
             <button class="add-to-cart" role="addCartItem" data-id="${product.id}">Добавить в корзину</button>
         </c:forEach>
     </div>

     <%--КОРЗИНА--%>
     <c:if test="${sessionScope.user.customer.cart != null}">
         <div class="cart">
             <div><b>Корзина:</b> &nbsp;</div>
             <div>Количество: <span class ="cart-quantity">${sessionScope.user.customer.cart.itemCount}</span>&nbsp;</div>
             <div>Цена: <span class="cart-total">${sessionScope.user.customer.cart.total}</span>&nbsp;</div>
             <div><a href="/cart">Перейти в корзину</a></div>
         </div>
     </c:if>
 </w:wrapper>
