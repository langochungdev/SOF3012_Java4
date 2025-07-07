<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        body { font-family: Arial; }
        .tab-header { display: flex; border-bottom: 1px solid #e67e22; margin-bottom: 5px; }
        .tab {
            padding: 8px 16px;
            border: 1px solid #e67e22;
            border-bottom: none;
            cursor: pointer;
            font-weight: bold;
            color: #555;
            background-color: #fdfdfd;
        }
        .tab.active { color: red; background-color: white; }
        .tab-content { border: 1px solid #e67e22; padding: 15px; display: none; }
        .tab-content.active { display: block; }
        table {
            width: 100%; border-collapse: collapse; margin-top: 10px;
        }
        th, td {
            border: 1px solid #e67e22;
            padding: 8px;
            text-align: center;
        }
        th { color: red; }
        select {
            padding: 6px;
            border: 1px solid #e67e22;
            margin-top: 10px;
        }
    </style>
    <script>
        function showTab(index) {
            const tabs = document.querySelectorAll('.tab');
            const contents = document.querySelectorAll('.tab-content');
            tabs.forEach(t => t.classList.remove('active'));
            contents.forEach(c => c.classList.remove('active'));
            tabs[index].classList.add('active');
            contents[index].classList.add('active');
        }
        function redirectTo(videoId, tabIndex) {
            window.location = "reports?videoId=" + videoId + "&tab=" + tabIndex;
        }
        window.onload = function () {
            const activeTab = ${tab != null ? tab : 0};
            showTab(activeTab);
        }
    </script>
</head>
<body>

<div class="tab-header">
    <div class="tab" onclick="showTab(0)">Favorites</div>
    <div class="tab" onclick="showTab(1)">Favorite Users</div>
    <div class="tab" onclick="showTab(2)">Shared Friends</div>
</div>

<!-- Tab 1 -->
<div class="tab-content">
    <table>
        <thead>
            <tr>
                <th>Video Title</th>
                <th>Favorite Count</th>
                <th>Latest Date</th>
                <th>Oldest Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${stats}">
                <tr>
                    <td>${row[0]}</td>
                    <td>${row[1]}</td>
                    <td>${row[2]}</td>
                    <td>${row[3]}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<!-- Tab 2 -->
<div class="tab-content">
    <label>Video Title?</label>
    <select onchange="redirectTo(this.value, 1)">
        <option value="">-- Select --</option>
        <c:forEach var="v" items="${videos}">
            <option value="${v.id}" ${v.id == videoId ? "selected" : ""}>${v.title}</option>
        </c:forEach>
    </select>

    <c:if test="${not empty favoriteUsers}">
        <table>
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Email</th>
                    <th>Favorite Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="f" items="${favoriteUsers}">
                    <tr>
                        <td>${f.user.id}</td>
                        <td>${f.user.fullname}</td>
                        <td>${f.user.email}</td>
                        <td>${f.likeDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>

<!-- Tab 3 -->
<div class="tab-content">
    <label>Video Title?</label>
    <select onchange="redirectTo(this.value, 2)">
        <option value="">-- Select --</option>
        <c:forEach var="v" items="${videos}">
            <option value="${v.id}" ${v.id == videoId ? "selected" : ""}>${v.title}</option>
        </c:forEach>
    </select>

    <c:if test="${not empty shared}">
        <table>
            <thead>
                <tr>
                    <th>Sender Name</th>
                    <th>Sender Email</th>
                    <th>Receiver Email</th>
                    <th>Sent Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="s" items="${shared}">
                    <tr>
                        <td>${s.user.fullname}</td>
                        <td>${s.user.email}</td>
                        <td>${s.emails}</td>
                        <td>${s.shareDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>

</body>
</html>
