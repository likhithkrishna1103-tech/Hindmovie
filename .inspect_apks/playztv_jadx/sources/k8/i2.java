package k8;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i2 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7241u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public /* synthetic */ Bundle f7242v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public /* synthetic */ g2 f7243w;

    public /* synthetic */ i2() {
        this.f7241u = 0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        Object obj;
        switch (this.f7241u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g2 g2Var = this.f7243w;
                Bundle bundle2 = this.f7242v;
                wb.c cVar = g2Var.Q;
                k1 k1Var = (k1) g2Var.f2454v;
                if (bundle2.isEmpty()) {
                    bundle = bundle2;
                } else {
                    Bundle bundleW = g2Var.n1().U.W();
                    e eVar = k1Var.A;
                    bundle = eVar.A1(null, w.f7484h1) ? new Bundle(bundleW) : bundleW;
                    for (String str : bundle2.keySet()) {
                        Object obj2 = bundle2.get(str);
                        if (obj2 != null && !(obj2 instanceof String) && !(obj2 instanceof Long) && !(obj2 instanceof Double)) {
                            g2Var.o1();
                            if (h4.Y1(obj2)) {
                                g2Var.o1();
                                obj = obj2;
                                h4.T1(cVar, null, 27, null, null, 0);
                            } else {
                                obj = obj2;
                            }
                            g2Var.g().F.b(str, obj, "Invalid default event parameter type. Name, value");
                        } else if (h4.u2(str)) {
                            g2Var.g().F.c(str, "Invalid default event parameter name. Name");
                        } else if (obj2 == null) {
                            bundle.remove(str);
                        } else {
                            h4 h4VarO1 = g2Var.o1();
                            eVar.getClass();
                            if (h4VarO1.b2("param", str, 500, obj2)) {
                                g2Var.o1().I1(bundle, str, obj2);
                            }
                        }
                    }
                    g2Var.o1();
                    int i = eVar.o1().g2(201500000) ? 100 : 25;
                    if (bundle.size() > i) {
                        int i10 = 0;
                        for (String str2 : new TreeSet(bundle.keySet())) {
                            i10++;
                            if (i10 > i) {
                                bundle.remove(str2);
                            }
                        }
                        g2Var.o1();
                        h4.T1(cVar, null, 26, null, null, 0);
                        g2Var.g().F.d("Too many default event parameters set. Discarding beyond event parameter limit");
                    }
                }
                g2Var.n1().U.c0(bundle);
                if (!bundle2.isEmpty() || k1Var.A.A1(null, w.f7478f1)) {
                    z2 z2VarP = k1Var.p();
                    z2VarP.p1();
                    z2VarP.t1();
                    z2VarP.w1(new ab.c(z2VarP, z2VarP.I1(false), bundle, 8));
                }
                break;
            case 1:
                g2 g2Var2 = this.f7243w;
                Bundle bundle3 = this.f7242v;
                g2Var2.p1();
                g2Var2.t1();
                String string = bundle3.getString("name");
                t7.v.d(string);
                k1 k1Var2 = (k1) g2Var2.f2454v;
                if (!k1Var2.h()) {
                    g2Var2.g().I.d("Conditional property not cleared since app measurement is disabled");
                } else {
                    e4 e4Var = new e4(0L, null, string, "");
                    try {
                        h4 h4VarO12 = g2Var2.o1();
                        bundle3.getString("app_id");
                        k1Var2.p().y1(new d(bundle3.getString("app_id"), "", e4Var, bundle3.getLong("creation_timestamp"), bundle3.getBoolean("active"), bundle3.getString("trigger_event_name"), null, bundle3.getLong("trigger_timeout"), null, bundle3.getLong("time_to_live"), h4VarO12.E1(bundle3.getString("expired_event_name"), bundle3.getBundle("expired_event_params"), "", bundle3.getLong("creation_timestamp"), true)));
                    } catch (IllegalArgumentException unused) {
                        return;
                    }
                }
                break;
            default:
                g2 g2Var3 = this.f7243w;
                Bundle bundle4 = this.f7242v;
                g2Var3.p1();
                g2Var3.t1();
                String string2 = bundle4.getString("name");
                String string3 = bundle4.getString("origin");
                t7.v.d(string2);
                t7.v.d(string3);
                t7.v.h(bundle4.get("value"));
                k1 k1Var3 = (k1) g2Var3.f2454v;
                if (!k1Var3.h()) {
                    g2Var3.g().I.d("Conditional property not set since app measurement is disabled");
                } else {
                    e4 e4Var2 = new e4(bundle4.getLong("triggered_timestamp"), bundle4.get("value"), string2, string3);
                    try {
                        h4 h4VarO13 = g2Var3.o1();
                        bundle4.getString("app_id");
                        v vVarE1 = h4VarO13.E1(bundle4.getString("triggered_event_name"), bundle4.getBundle("triggered_event_params"), string3, 0L, true);
                        h4 h4VarO14 = g2Var3.o1();
                        bundle4.getString("app_id");
                        v vVarE12 = h4VarO14.E1(bundle4.getString("timed_out_event_name"), bundle4.getBundle("timed_out_event_params"), string3, 0L, true);
                        h4 h4VarO15 = g2Var3.o1();
                        bundle4.getString("app_id");
                        k1Var3.p().y1(new d(bundle4.getString("app_id"), string3, e4Var2, bundle4.getLong("creation_timestamp"), false, bundle4.getString("trigger_event_name"), vVarE12, bundle4.getLong("trigger_timeout"), vVarE1, bundle4.getLong("time_to_live"), h4VarO15.E1(bundle4.getString("expired_event_name"), bundle4.getBundle("expired_event_params"), string3, 0L, true)));
                    } catch (IllegalArgumentException unused2) {
                        return;
                    }
                }
                break;
        }
    }

    public /* synthetic */ i2(g2 g2Var, Bundle bundle, int i) {
        this.f7241u = i;
        this.f7242v = bundle;
        this.f7243w = g2Var;
    }
}
