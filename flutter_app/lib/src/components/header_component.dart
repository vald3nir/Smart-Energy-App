import 'package:flutter/material.dart';

// -----------------------------------------------------------------------------
// Paraments
// -----------------------------------------------------------------------------

class HeaderParameters {
  final String imageLogo;
  final String titleText;
  final Color titleColor;

  HeaderParameters({
    required this.imageLogo,
    required this.titleText,
    required this.titleColor,
  });
}

// -----------------------------------------------------------------------------
// Component
// -----------------------------------------------------------------------------

class HeaderComponent extends StatelessWidget {
  final HeaderParameters parameters;

  const HeaderComponent({
    Key? key,
    required this.parameters,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        // ---------------------------------------------------------------------
        // Divider
        // ---------------------------------------------------------------------
       
        const SizedBox(
          height: 50,
        ),

        // ---------------------------------------------------------------------
        // Logo
        // ---------------------------------------------------------------------

        Image.asset(
          parameters.imageLogo,
          width: 100,
          height: 100,
        ),

        // ---------------------------------------------------------------------
        // Divider
        // ---------------------------------------------------------------------

        const SizedBox(
          height: 10,
        ),

        // ---------------------------------------------------------------------
        // Title
        // ---------------------------------------------------------------------

        Align(
          alignment: Alignment.center,
          child: Text(
            parameters.titleText,
            style: TextStyle(color: parameters.titleColor, fontSize: 22),
          ),
        )

        // ---------------------------------------------------------------------
      ],
    );
  }
}
