package f9;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r2 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4368v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Bundle f4369w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ x2 f4370x;

    public /* synthetic */ r2(x2 x2Var, Bundle bundle, int i) {
        this.f4368v = i;
        this.f4369w = bundle;
        this.f4370x = x2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        switch (this.f4368v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                x2 x2Var = this.f4370x;
                x2Var.m1();
                x2Var.n1();
                Bundle bundle2 = this.f4369w;
                String string = bundle2.getString("name");
                String string2 = bundle2.getString("origin");
                o8.u.d(string);
                o8.u.d(string2);
                o8.u.g(bundle2.get("value"));
                r1 r1Var = (r1) x2Var.f307w;
                if (!r1Var.a()) {
                    w0 w0Var = r1Var.A;
                    r1.g(w0Var);
                    w0Var.J.a("Conditional property not set since app measurement is disabled");
                } else {
                    s4 s4Var = new s4(bundle2.getLong("triggered_timestamp"), bundle2.get("value"), string, string2);
                    try {
                        u4 u4Var = r1Var.D;
                        r1.e(u4Var);
                        bundle2.getString("app_id");
                        v vVarP1 = u4Var.P1(bundle2.getString("triggered_event_name"), bundle2.getBundle("triggered_event_params"), string2, 0L, true);
                        r1.e(u4Var);
                        bundle2.getString("app_id");
                        v vVarP12 = u4Var.P1(bundle2.getString("timed_out_event_name"), bundle2.getBundle("timed_out_event_params"), string2, 0L, true);
                        bundle2.getString("app_id");
                        r1Var.j().F1(new e(bundle2.getString("app_id"), string2, s4Var, bundle2.getLong("creation_timestamp"), false, bundle2.getString("trigger_event_name"), vVarP12, bundle2.getLong("trigger_timeout"), vVarP1, bundle2.getLong("time_to_live"), u4Var.P1(bundle2.getString("expired_event_name"), bundle2.getBundle("expired_event_params"), string2, 0L, true)));
                    } catch (IllegalArgumentException unused) {
                        return;
                    }
                }
                break;
            case 1:
                x2 x2Var2 = this.f4370x;
                x2Var2.m1();
                x2Var2.n1();
                Bundle bundle3 = this.f4369w;
                String string3 = bundle3.getString("name");
                o8.u.d(string3);
                r1 r1Var2 = (r1) x2Var2.f307w;
                if (!r1Var2.a()) {
                    w0 w0Var2 = r1Var2.A;
                    r1.g(w0Var2);
                    w0Var2.J.a("Conditional property not cleared since app measurement is disabled");
                } else {
                    s4 s4Var2 = new s4(0L, null, string3, "");
                    try {
                        u4 u4Var2 = r1Var2.D;
                        r1.e(u4Var2);
                        bundle3.getString("app_id");
                        r1Var2.j().F1(new e(bundle3.getString("app_id"), "", s4Var2, bundle3.getLong("creation_timestamp"), bundle3.getBoolean("active"), bundle3.getString("trigger_event_name"), null, bundle3.getLong("trigger_timeout"), null, bundle3.getLong("time_to_live"), u4Var2.P1(bundle3.getString("expired_event_name"), bundle3.getBundle("expired_event_params"), "", bundle3.getLong("creation_timestamp"), true)));
                    } catch (IllegalArgumentException unused2) {
                        return;
                    }
                }
                break;
            default:
                x2 x2Var3 = this.f4370x;
                p6.d dVar = x2Var3.S;
                r1 r1Var3 = (r1) x2Var3.f307w;
                Bundle bundle4 = this.f4369w;
                if (bundle4.isEmpty()) {
                    bundle = bundle4;
                } else {
                    f1 f1Var = r1Var3.f4367z;
                    u4 u4Var3 = r1Var3.D;
                    g gVar = r1Var3.f4366y;
                    w0 w0Var3 = r1Var3.A;
                    r1.e(f1Var);
                    bundle = new Bundle(f1Var.U.C());
                    for (String str : bundle4.keySet()) {
                        Object obj = bundle4.get(str);
                        if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                            r1.e(u4Var3);
                            if (u4.v2(obj)) {
                                u4.C1(dVar, null, 27, null, null, 0);
                            }
                            r1.g(w0Var3);
                            w0Var3.G.c(str, obj, "Invalid default event parameter type. Name, value");
                        } else if (u4.L1(str)) {
                            r1.g(w0Var3);
                            w0Var3.G.b(str, "Invalid default event parameter name. Name");
                        } else if (obj == null) {
                            bundle.remove(str);
                        } else {
                            r1.e(u4Var3);
                            gVar.getClass();
                            if (u4Var3.w2("param", str, 500, obj)) {
                                u4Var3.B1(bundle, str, obj);
                            }
                        }
                    }
                    r1.e(u4Var3);
                    u4 u4Var4 = ((r1) gVar.f307w).D;
                    r1.e(u4Var4);
                    int i = u4Var4.S1(201500000) ? 100 : 25;
                    if (bundle.size() > i) {
                        int i10 = 0;
                        for (String str2 : new TreeSet(bundle.keySet())) {
                            i10++;
                            if (i10 > i) {
                                bundle.remove(str2);
                            }
                        }
                        r1.e(u4Var3);
                        u4.C1(dVar, null, 26, null, null, 0);
                        r1.g(w0Var3);
                        w0Var3.G.a("Too many default event parameters set. Discarding beyond event parameter limit");
                    }
                }
                f1 f1Var2 = r1Var3.f4367z;
                r1.e(f1Var2);
                f1Var2.U.E(bundle);
                if (!bundle4.isEmpty() || r1Var3.f4366y.w1(null, f0.X0)) {
                    r1Var3.j().r1(bundle);
                }
                break;
        }
    }
}
