import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../l10n/app_localizations.dart';
import 'locale_provider.dart';

class LanguageSelectionPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final localizations = AppLocalizations.of(context)!; // Fetch localized strings
    final locale = Localizations.localeOf(context);
    print("Current Locale: $locale");
    return Scaffold(
      appBar: AppBar(
        title: Text(AppLocalizations.of(context)!.selectLanguage), // Use localized string for app bar title
      ),
      body: Column(
        children: [
          ListTile(
            leading: Image.asset('assets/flags/usa.png'), // Flag for English
            title: Text(AppLocalizations.of(context)!.english), // Use localized string for English
            onTap: () {
              Provider.of<LocaleProvider>(context, listen: false).setLocale(const Locale('en', ''));
              Navigator.of(context).pop();
            },
          ),
          ListTile(
            leading: Image.asset('assets/flags/greece.png'), // Flag for Greek
            title: Text(AppLocalizations.of(context)!.greek), // Use localized string for Greek
            onTap: () {
              Provider.of<LocaleProvider>(context, listen: false).setLocale(const Locale('el', ''));
              Navigator.of(context).pop();
            },
          ),
          // Add more languages and flags here
        ],
      ),
    );
  }
}
