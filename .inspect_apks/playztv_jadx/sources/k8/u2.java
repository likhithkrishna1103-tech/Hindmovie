package k8;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.m8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u2 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7438u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public /* synthetic */ int f7439v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public /* synthetic */ Object f7440w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public /* synthetic */ Object f7441x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Cloneable f7442y;

    public /* synthetic */ u2(int i) {
        this.f7438u = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7438u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ab.c cVar = (ab.c) this.f7440w;
                int i = this.f7439v;
                Exception exc = (Exception) this.f7441x;
                byte[] bArr = (byte[]) this.f7442y;
                k1 k1Var = (k1) ((u5.c) cVar.f781w).f12782v;
                e eVar = k1Var.A;
                h4 h4Var = k1Var.F;
                p0 p0Var = k1Var.C;
                if ((i == 200 || i == 204 || i == 304) && exc == null) {
                    z0 z0Var = k1Var.B;
                    k1.d(z0Var);
                    z0Var.P.a(true);
                    if (bArr == null || bArr.length == 0) {
                        k1.f(p0Var);
                        p0Var.H.d("Deferred Deep Link response empty.");
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject(new String(bArr));
                            String strOptString = jSONObject.optString("deeplink", "");
                            if (!TextUtils.isEmpty(strOptString)) {
                                String strOptString2 = jSONObject.optString("gclid", "");
                                String strOptString3 = jSONObject.optString("gbraid", "");
                                String strOptString4 = jSONObject.optString("gad_source", "");
                                double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
                                Bundle bundle = new Bundle();
                                m8.a();
                                f0 f0Var = w.T0;
                                if (!eVar.A1(null, f0Var)) {
                                    k1.d(h4Var);
                                    if (!h4Var.w2(strOptString)) {
                                        k1.f(p0Var);
                                        p0Var.D.b(strOptString2, strOptString, "Deferred Deep Link validation failed. gclid, deep link");
                                    }
                                } else {
                                    k1.d(h4Var);
                                    if (!h4Var.w2(strOptString)) {
                                        k1.f(p0Var);
                                        p0Var.D.e("Deferred Deep Link validation failed. gclid, gbraid, deep link", strOptString2, strOptString3, strOptString);
                                    } else {
                                        if (!TextUtils.isEmpty(strOptString3)) {
                                            bundle.putString("gbraid", strOptString3);
                                        }
                                        if (!TextUtils.isEmpty(strOptString4)) {
                                            bundle.putString("gad_source", strOptString4);
                                        }
                                    }
                                }
                                m8.a();
                                eVar.A1(null, f0Var);
                                bundle.putString("gclid", strOptString2);
                                bundle.putString("_cis", "ddp");
                                k1Var.J.T1("auto", "_cmp", bundle);
                                k1.d(h4Var);
                                if (!TextUtils.isEmpty(strOptString) && h4Var.Z1(strOptString, dOptDouble)) {
                                    ((k1) h4Var.f2454v).f7282u.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                                    break;
                                }
                            } else {
                                k1.f(p0Var);
                                p0Var.H.d("Deferred Deep Link is empty.");
                            }
                        } catch (JSONException e10) {
                            k1.f(p0Var);
                            p0Var.A.c(e10, "Failed to parse the Deferred Deep Link response. exception");
                            return;
                        }
                    }
                } else {
                    k1.f(p0Var);
                    p0Var.D.b(Integer.valueOf(i), exc, "Network Request for Deferred Deep Link failed. response, exception");
                }
                break;
            default:
                rc.b bVar = (rc.b) this.f7440w;
                int i10 = this.f7439v;
                p0 p0Var2 = (p0) this.f7441x;
                Intent intent = (Intent) this.f7442y;
                l3 l3Var = (l3) ((Service) bVar.f11562v);
                if (l3Var.c(i10)) {
                    p0Var2.I.c(Integer.valueOf(i10), "Local AppMeasurementService processed last upload request. StartId");
                    bVar.N().I.d("Completed wakeful intent.");
                    l3Var.a(intent);
                }
                break;
        }
    }
}
