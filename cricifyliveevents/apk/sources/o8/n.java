package o8;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v.k f9683a = new v.k(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Locale f9684b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            Context context2 = u8.b.a(context).f1830a;
            return context2.getPackageManager().getApplicationLabel(context2.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context, int i) {
        Resources resources = context.getResources();
        String strA = a(context);
        if (i == 1) {
            return resources.getString(j8.b.common_google_play_services_install_text, strA);
        }
        if (i == 2) {
            return s8.b.f(context) ? resources.getString(j8.b.common_google_play_services_wear_update_text) : resources.getString(j8.b.common_google_play_services_update_text, strA);
        }
        if (i == 3) {
            return resources.getString(j8.b.common_google_play_services_enable_text, strA);
        }
        if (i == 5) {
            return d(context, "common_google_play_services_invalid_account_text", strA);
        }
        if (i == 7) {
            return d(context, "common_google_play_services_network_error_text", strA);
        }
        if (i == 9) {
            return resources.getString(j8.b.common_google_play_services_unsupported_text, strA);
        }
        if (i == 20) {
            return d(context, "common_google_play_services_restricted_profile_text", strA);
        }
        switch (i) {
            case 16:
                return d(context, "common_google_play_services_api_unavailable_text", strA);
            case 17:
                return d(context, "common_google_play_services_sign_in_failed_text", strA);
            case 18:
                return resources.getString(j8.b.common_google_play_services_updating_text, strA);
            default:
                return resources.getString(l8.j.common_google_play_services_unknown_issue, strA);
        }
    }

    public static String c(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(j8.b.common_google_play_services_install_title);
            case 2:
                return resources.getString(j8.b.common_google_play_services_update_title);
            case 3:
                return resources.getString(j8.b.common_google_play_services_enable_title);
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
            case 18:
                return null;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return e(context, "common_google_play_services_invalid_account_title");
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return e(context, "common_google_play_services_network_error_title");
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return e(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return e(context, "common_google_play_services_restricted_profile_title");
        }
    }

    public static String d(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strE = e(context, str);
        if (strE == null) {
            strE = resources.getString(l8.j.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, strE, str2);
    }

    public static String e(Context context, String str) {
        Resources resourcesForApplication;
        v.k kVar = f9683a;
        synchronized (kVar) {
            try {
                Configuration configuration = context.getResources().getConfiguration();
                Locale locale = (Build.VERSION.SDK_INT >= 24 ? new p0.g(new p0.j(p0.d.d(configuration))) : p0.g.a(configuration.locale)).f9874a.get(0);
                if (!locale.equals(f9684b)) {
                    kVar.clear();
                    f9684b = locale;
                }
                String str2 = (String) kVar.get(str);
                if (str2 != null) {
                    return str2;
                }
                AtomicBoolean atomicBoolean = l8.g.f7891a;
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
                } catch (PackageManager.NameNotFoundException unused) {
                    resourcesForApplication = null;
                }
                if (resourcesForApplication != null) {
                    int identifier = resourcesForApplication.getIdentifier(str, "string", "com.google.android.gms");
                    if (identifier == 0) {
                        Log.w("GoogleApiAvailability", "Missing resource: ".concat(str));
                    } else {
                        String string = resourcesForApplication.getString(identifier);
                        if (!TextUtils.isEmpty(string)) {
                            f9683a.put(str, string);
                            return string;
                        }
                        Log.w("GoogleApiAvailability", "Got empty resource: ".concat(str));
                    }
                }
                return null;
            } finally {
            }
        }
    }
}
