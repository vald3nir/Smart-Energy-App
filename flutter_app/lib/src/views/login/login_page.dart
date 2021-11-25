import 'package:flutter/material.dart';
import 'package:smart_energy_app/src/components/edit_text_component.dart';
import 'package:smart_energy_app/src/components/header_component.dart';

import 'login_view_model.dart';

// -----------------------------------------------------------------------------
// Constants
// -----------------------------------------------------------------------------

const primaryColor = Color(0xffffff00);

// -----------------------------------------------------------------------------
// Components
// -----------------------------------------------------------------------------

final headerComponent = HeaderComponent(
    parameters: HeaderParameters(
  imageLogo: 'assets/images/app_logo.png',
  titleText: 'Smart Energy',
  titleColor: primaryColor,
));

class EmailEditTextCompont extends EditTextComponent {
  EmailEditTextCompont({Key? key})
      : super(
            key: key,
            parameters: EditTextParameters(
                cursorColor: primaryColor,
                hint: 'Insira seu email',
                labelText: 'Email',
                textInputType: TextInputType.emailAddress));
}

class PasswordEditTextCompont extends EditTextComponent {
  PasswordEditTextCompont({Key? key})
      : super(
            key: key,
            parameters: EditTextParameters(
                cursorColor: primaryColor,
                hint: 'Insira sua senha',
                labelText: 'Senha',
                textInputType: TextInputType.name));
}

// -----------------------------------------------------------------------------
// View
// -----------------------------------------------------------------------------

class LoginPage extends StatefulWidget {
  const LoginPage({Key? key}) : super(key: key);

  @override
  State<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final viewModel = LoginViewModel();

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
              // ---------------------------------------------------------------
              // Header
              // ---------------------------------------------------------------

              headerComponent,

              // ---------------------------------------------------------------
              // Email field
              // ---------------------------------------------------------------

              const SizedBox(
                height: 50,
              ),

              EmailEditTextCompont(),

              // ---------------------------------------------------------------
              // Password field
              // ---------------------------------------------------------------
             
              const SizedBox(
                height: 50,
              ),

              PasswordEditTextCompont(),

              // ---------------------------------------------------------------
              //
              // ---------------------------------------------------------------

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
