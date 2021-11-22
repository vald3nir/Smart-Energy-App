import 'package:flutter/material.dart';

import 'login_view_model.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({Key? key}) : super(key: key);

  @override
  State<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final viewModel = LoginViewModel();
  static const primaryColor = Color(0xffffff00);
  final String logo = 'assets/images/app_logo.png';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      body: Center(
        child: SingleChildScrollView(
          padding: const EdgeInsets.only(left: 32, right: 32),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Image.asset(
                logo,
                width: 100,
                height: 100,
              ),
              const Align(
                alignment: Alignment.center,
                child: Text(
                  'Smart Energy',
                  style: TextStyle(color: primaryColor, fontSize: 24),
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(top: 50),
                child: TextFormField(
                  cursorColor: primaryColor,
                  controller: null,
                  keyboardType: TextInputType.emailAddress,
                  validator: (value) {
                    if (value!.isEmpty) {
                      return 'Insira seu email';
                    }
                  },
                  decoration: InputDecoration(
                      enabledBorder: OutlineInputBorder(
                        borderSide:
                            const BorderSide(width: 3, color: primaryColor),
                        borderRadius: BorderRadius.circular(15),
                      ),
                      focusedBorder: OutlineInputBorder(
                        borderSide:
                            const BorderSide(width: 3, color: primaryColor),
                        borderRadius: BorderRadius.circular(15),
                      ),
                      labelText: 'E-mail',
                      labelStyle: const TextStyle(color: primaryColor)),
                  textAlign: TextAlign.center,
                  style: const TextStyle(color: primaryColor, fontSize: 25),
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(top: 25),
                child: TextFormField(
                  cursorColor: primaryColor,
                  controller: null,
                  obscureText: true,
                  validator: (value) {
                    if (value!.isEmpty) {
                      return 'Insira sua senha!';
                    }
                  },
                  decoration: InputDecoration(
                    enabledBorder: OutlineInputBorder(
                      borderSide:
                          const BorderSide(width: 3, color: primaryColor),
                      borderRadius: BorderRadius.circular(15),
                    ),
                    focusedBorder: OutlineInputBorder(
                      borderSide:
                          const BorderSide(width: 3, color: primaryColor),
                      borderRadius: BorderRadius.circular(15),
                    ),
                    labelText: 'Senha',
                    labelStyle: const TextStyle(color: primaryColor),
                  ),
                  textAlign: TextAlign.center,
                  style: const TextStyle(color: primaryColor, fontSize: 25),
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(top: 45, bottom: 20),
                child: SizedBox(
                  height: 50,
                  child: ElevatedButton(
                    onPressed: () {},
                    child: const Text(
                      'Entrar',
                      style: TextStyle(color: Colors.black, fontSize: 18),
                    ),
                    style: ElevatedButton.styleFrom(primary: primaryColor),
                  ),
                ),
              ),
              SizedBox(
                height: 50,
                child: ElevatedButton(
                  onPressed: () {},
                  child: const Text(
                    'Cadastrar',
                    style: TextStyle(color: Colors.white, fontSize: 18),
                  ),
                  style: ElevatedButton.styleFrom(primary: Colors.black),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
