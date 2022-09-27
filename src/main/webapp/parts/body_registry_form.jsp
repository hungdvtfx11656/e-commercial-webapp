<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="login_form">
    <div class="row justify-content-center g-0">
        <div class="col-11 col-md-6">
            <div class="row py-5">
                <div class="col-12 col-md-6">
                    <h2 class="text-center mb-3">Sign up</h2>
                    <form action="Registry" method="post">
                        <div class="mb-3">
                            <input type="email" name="registry_usr" id="registry_usr" class="form-control bg-light" placeholder="Your email address" required>
                        </div>
                        <div class="mb-3">
                            <input type="password" name="registry_pwd" id="registry_pwd" minlength="8" class="form-control bg-light" placeholder="Your password" required>
                        </div>
                        <div class="mb-3">
                            <input type="text" name="registry_username" id="registry_username" class="form-control bg-light" placeholder="Your name" required>
                        </div>
                        <div class="mb-3">
                            <input type="text" name="registry_address" id="registry_address" class="form-control bg-light" placeholder="Your address" required>
                        </div>
                        <div class="mb-3">
                            <input type="text" name="registry_phone" id="registry_phone" maxlength="10" minlength="10" class="form-control bg-light" placeholder="Your phone number" required>
                        </div>
                        <div class="d-flex justify-content-center">
                            <button type="submit" class="btn btn-primary rounded-pill w-50">Sign up</button>
                        </div>
                    </form>
                </div>
                <div class="col-6 d-none d-md-block">
                    <h2 class="text-center mb-3">Welcome!</h2>
                    <p class="text-center">Sign up to have more promotion news and coupons.</p>
                </div>
            </div>
        </div>
    </div>
</div>