
import 'package:flutter/material.dart';

const PrimaryColor = const Color(0xFF376322);
const PrimaryLightColor = const Color(0xFF64914d);
const PrimaryDarkColor = const Color(0xFF0A3800);

const SecondaryColor = const Color(0xFFCDDC39);
const SecondaryLightColor = const Color(0xFFFFFF6E);
const SecondaryDarkColor = const Color(0xFF99AA00);

const PrimaryTextColor = const Color(0xFFFFFFFF);
const SecondaryTextColor = const Color(0xFF000000);

class SteyrerTheme {
  static final ThemeData defaultTheme = _buildMyTheme();

  static ThemeData _buildMyTheme() {
    final ThemeData base = ThemeData.dark();

    return base.copyWith(
      accentColor: SecondaryColor,
      accentColorBrightness: Brightness.dark,

      primaryColor: PrimaryColor,
      primaryColorDark: PrimaryDarkColor,
      primaryColorLight: PrimaryLightColor,
      primaryColorBrightness: Brightness.light,

      buttonTheme: base.buttonTheme.copyWith(
        buttonColor: SecondaryColor,
        textTheme: ButtonTextTheme.primary,
      ),

      scaffoldBackgroundColor: PrimaryTextColor,
      cardColor: Color(0xFFAAAAAA),
      textSelectionColor: PrimaryLightColor,
      backgroundColor: PrimaryTextColor,

      textTheme: base.textTheme.copyWith(
        headline1: base.textTheme.headline1.copyWith(color: SecondaryTextColor),
        bodyText1: base.textTheme.bodyText1.copyWith(color: SecondaryTextColor),
        bodyText2: base.textTheme.bodyText2.copyWith(color: SecondaryTextColor),
      )
    );
  }
}