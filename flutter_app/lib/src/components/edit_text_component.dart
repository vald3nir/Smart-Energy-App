import 'package:flutter/material.dart';

// -----------------------------------------------------------------------------
// Paraments
// -----------------------------------------------------------------------------

class EditTextParameters {
  final Color cursorColor;
  final String hint;
  final String labelText;
  final TextInputType textInputType;

  EditTextParameters({
    required this.cursorColor,
    required this.hint,
    required this.labelText,
    required this.textInputType,
  });
}

// -----------------------------------------------------------------------------
// Component
// -----------------------------------------------------------------------------

class EditTextComponent extends StatelessWidget {
  final EditTextParameters parameters;

  const EditTextComponent({Key? key, required this.parameters})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return TextFormField(
      cursorColor: parameters.cursorColor,
      controller: null,
      keyboardType: parameters.textInputType,

      // -----------------------------------------------------------------------
      // Field validation
      // -----------------------------------------------------------------------

      validator: (value) {
        if (value!.isEmpty) {
          return parameters.hint;
        }
      },

      // -----------------------------------------------------------------------
      // Decorations
      // -----------------------------------------------------------------------

      decoration: InputDecoration(

          // -------------------------------------------------------------------
          // Edge adjustment
          // -------------------------------------------------------------------

          enabledBorder: OutlineInputBorder(
            borderSide: BorderSide(width: 2, color: parameters.cursorColor),
            borderRadius: BorderRadius.circular(15),
          ),
         
          focusedBorder: OutlineInputBorder(
            borderSide: BorderSide(width: 3, color: parameters.cursorColor),
            borderRadius: BorderRadius.circular(15),
          ),
        
          // -------------------------------------------------------------------
          // Text adjustment
          // -------------------------------------------------------------------

          labelText: parameters.labelText,
          labelStyle: TextStyle(color: parameters.cursorColor)),

      textAlign: TextAlign.center,

      style: TextStyle(color: parameters.cursorColor, fontSize: 18),
    );
  }
}
