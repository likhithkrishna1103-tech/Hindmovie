package f9;

import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h1 implements z2 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final r1 f4203v;

    public /* synthetic */ h1(r1 r1Var) {
        this.f4203v = r1Var;
    }

    public boolean a() {
        r1 r1Var = this.f4203v;
        try {
            b7.e eVarA = u8.b.a(r1Var.f4363v);
            if (eVarA != null) {
                return eVarA.b(128, "com.android.vending").versionCode >= 80837300;
            }
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.J.a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e9) {
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.J.b(e9, "Failed to retrieve Play Store version for Install Referrer");
            return false;
        }
    }

    @Override // f9.z2
    public void f(int i, Throwable th, byte[] bArr) {
        int i10;
        w0 w0Var;
        w0 w0Var2;
        r1 r1Var = this.f4203v;
        w0 w0Var3 = r1Var.A;
        if (i != 200 && i != 204) {
            i10 = 304;
            if (i != 304) {
                i10 = i;
            }
            r1.g(w0Var3);
            w0Var3.E.c(Integer.valueOf(i10), th, "Network Request for Deferred Deep Link failed. response, exception");
        }
        i10 = i;
        if (th == null) {
            f1 f1Var = r1Var.f4367z;
            r1.e(f1Var);
            f1Var.P.b(true);
            if (bArr == null || bArr.length == 0) {
                r1.g(w0Var3);
                w0Var3.I.a("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String strOptString = jSONObject.optString("deeplink", "");
                if (TextUtils.isEmpty(strOptString)) {
                    r1.g(w0Var3);
                    w0Var3.I.a("Deferred Deep Link is empty.");
                    return;
                }
                String strOptString2 = jSONObject.optString("gclid", "");
                String strOptString3 = jSONObject.optString("gbraid", "");
                String strOptString4 = jSONObject.optString("gad_source", "");
                double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
                Bundle bundle = new Bundle();
                u4 u4Var = r1Var.D;
                r1.e(u4Var);
                r1 r1Var2 = (r1) u4Var.f307w;
                if (TextUtils.isEmpty(strOptString)) {
                    w0Var2 = w0Var3;
                } else {
                    Context context = r1Var2.f4363v;
                    w0Var2 = w0Var3;
                    try {
                        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0);
                        if (listQueryIntentActivities != null && !listQueryIntentActivities.isEmpty()) {
                            if (!TextUtils.isEmpty(strOptString3)) {
                                bundle.putString("gbraid", strOptString3);
                            }
                            if (!TextUtils.isEmpty(strOptString4)) {
                                bundle.putString("gad_source", strOptString4);
                            }
                            bundle.putString("gclid", strOptString2);
                            bundle.putString("_cis", "ddp");
                            r1Var.H.t1("auto", "_cmp", bundle);
                            if (TextUtils.isEmpty(strOptString)) {
                                return;
                            }
                            try {
                                SharedPreferences.Editor editorEdit = context.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                editorEdit.putString("deeplink", strOptString);
                                editorEdit.putLong("timestamp", Double.doubleToRawLongBits(dOptDouble));
                                if (editorEdit.commit()) {
                                    Intent intent = new Intent("android.google.analytics.action.DEEPLINK_ACTION");
                                    Context context2 = r1Var2.f4363v;
                                    if (Build.VERSION.SDK_INT < 34) {
                                        context2.sendBroadcast(intent);
                                        return;
                                    } else {
                                        context2.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
                                        return;
                                    }
                                }
                                return;
                            } catch (RuntimeException e9) {
                                w0 w0Var4 = ((r1) u4Var.f307w).A;
                                r1.g(w0Var4);
                                w0Var4.B.b(e9, "Failed to persist Deferred Deep Link. exception");
                                return;
                            }
                        }
                    } catch (JSONException e10) {
                        e = e10;
                        w0Var = w0Var2;
                        r1.g(w0Var);
                        w0Var.B.b(e, "Failed to parse the Deferred Deep Link response. exception");
                        return;
                    }
                }
                r1.g(w0Var2);
                w0Var = w0Var2;
                try {
                    w0Var.E.d("Deferred Deep Link validation failed. gclid, gbraid, deep link", strOptString2, strOptString3, strOptString);
                    return;
                } catch (JSONException e11) {
                    e = e11;
                    r1.g(w0Var);
                    w0Var.B.b(e, "Failed to parse the Deferred Deep Link response. exception");
                    return;
                }
            } catch (JSONException e12) {
                e = e12;
                w0Var = w0Var3;
            }
        }
        r1.g(w0Var3);
        w0Var3.E.c(Integer.valueOf(i10), th, "Network Request for Deferred Deep Link failed. response, exception");
    }

    public h1(q4 q4Var) {
        this.f4203v = q4Var.G;
    }
}
