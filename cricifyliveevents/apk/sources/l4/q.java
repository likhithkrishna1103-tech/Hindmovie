package l4;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.Rating;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f7752a;

    public q(Bundle bundle) {
        this.f7752a = new Bundle(bundle);
    }

    public static boolean f(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString("gcm.n.e".replace("gcm.n.", "gcm.notification.")));
    }

    public static String m(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public boolean a(String str) {
        String strE = e(str);
        return "1".equals(strE) || Boolean.parseBoolean(strE);
    }

    public Integer b(String str) {
        String strE = e(str);
        if (TextUtils.isEmpty(strE)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(strE));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + m(str) + "(" + strE + ") into an int");
            return null;
        }
    }

    public JSONArray c(String str) {
        String strE = e(str);
        if (TextUtils.isEmpty(strE)) {
            return null;
        }
        try {
            return new JSONArray(strE);
        } catch (JSONException unused) {
            Log.w("NotificationParams", "Malformed JSON for key " + m(str) + ": " + strE + ", falling back to default");
            return null;
        }
    }

    public String d(Resources resources, String str, String str2) {
        String[] strArr;
        String strE = e(str2);
        if (!TextUtils.isEmpty(strE)) {
            return strE;
        }
        String strE2 = e(str2.concat("_loc_key"));
        if (TextUtils.isEmpty(strE2)) {
            return null;
        }
        int identifier = resources.getIdentifier(strE2, "string", str);
        if (identifier == 0) {
            Log.w("NotificationParams", m(str2.concat("_loc_key")) + " resource not found: " + str2 + " Default value will be used.");
            return null;
        }
        JSONArray jSONArrayC = c(str2.concat("_loc_args"));
        if (jSONArrayC == null) {
            strArr = null;
        } else {
            int length = jSONArrayC.length();
            strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = jSONArrayC.optString(i);
            }
        }
        if (strArr == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, strArr);
        } catch (MissingFormatArgumentException e9) {
            Log.w("NotificationParams", "Missing format argument for " + m(str2) + ": " + Arrays.toString(strArr) + " Default value will be used.", e9);
            return null;
        }
    }

    public String e(String str) {
        Bundle bundle = this.f7752a;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            String strReplace = !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
            if (bundle.containsKey(strReplace)) {
                str = strReplace;
            }
        }
        return bundle.getString(str);
    }

    public Bundle g() {
        Bundle bundle = this.f7752a;
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle.keySet()) {
            if (!str.startsWith("google.c.a.") && !str.equals("from")) {
                bundle2.remove(str);
            }
        }
        return bundle2;
    }

    public void h(String str, Bitmap bitmap) {
        Integer num = (Integer) r.f7753x.get(str);
        if (num != null && num.intValue() != 2) {
            throw new IllegalArgumentException(l0.e.k("The ", str, " key cannot be used to put a Bitmap"));
        }
        this.f7752a.putParcelable(str, bitmap);
    }

    public void i(String str, long j4) {
        Integer num = (Integer) r.f7753x.get(str);
        if (num != null && num.intValue() != 0) {
            throw new IllegalArgumentException(l0.e.k("The ", str, " key cannot be used to put a long"));
        }
        this.f7752a.putLong(str, j4);
    }

    public void j(String str, l0 l0Var) {
        Rating rating;
        float f = l0Var.f7739w;
        int i = l0Var.f7738v;
        Integer num = (Integer) r.f7753x.get(str);
        if (num != null && num.intValue() != 3) {
            throw new IllegalArgumentException(l0.e.k("The ", str, " key cannot be used to put a Rating"));
        }
        if (l0Var.f7740x != null) {
            rating = l0Var.f7740x;
        } else {
            if (l0Var.b()) {
                switch (i) {
                    case 1:
                        l0Var.f7740x = Rating.newHeartRating(i == 1 && f == 1.0f);
                        break;
                    case 2:
                        l0Var.f7740x = Rating.newThumbRating(i == 2 && f == 1.0f);
                        break;
                    case 3:
                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                        l0Var.f7740x = Rating.newStarRating(i, l0Var.a());
                        break;
                    case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                        if (i != 6 || !l0Var.b()) {
                            f = -1.0f;
                        }
                        l0Var.f7740x = Rating.newPercentageRating(f);
                        break;
                    default:
                        rating = null;
                        break;
                }
            } else {
                l0Var.f7740x = Rating.newUnratedRating(i);
            }
            rating = l0Var.f7740x;
        }
        this.f7752a.putParcelable(str, rating);
    }

    public void k(String str, String str2) {
        Integer num = (Integer) r.f7753x.get(str);
        if (num != null && num.intValue() != 1) {
            throw new IllegalArgumentException(l0.e.k("The ", str, " key cannot be used to put a String"));
        }
        this.f7752a.putCharSequence(str, str2);
    }

    public void l(String str, CharSequence charSequence) {
        Integer num = (Integer) r.f7753x.get(str);
        if (num != null && num.intValue() != 1) {
            throw new IllegalArgumentException(l0.e.k("The ", str, " key cannot be used to put a CharSequence"));
        }
        this.f7752a.putCharSequence(str, charSequence);
    }

    public q() {
        this.f7752a = new Bundle();
    }
}
