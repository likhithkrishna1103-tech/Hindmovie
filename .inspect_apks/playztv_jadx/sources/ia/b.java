package ia;

import aa.c1;
import aa.g0;
import aa.h0;
import aa.j0;
import aa.q;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import c7.j;
import com.google.firebase.abt.component.AbtRegistrar;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import na.e;
import na.n;
import o2.b0;
import o2.z0;
import o8.d;
import p1.f0;
import p1.g1;
import p1.h1;
import p1.m;
import p1.m0;
import p1.m1;
import p1.p;
import p1.t;
import p2.i;
import q1.c;
import q3.r;
import s1.h;
import w2.o;
import z9.f;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements e, j7.e, f, nb.a, h, d {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6471u;

    public /* synthetic */ b(int i) {
        this.f6471u = i;
    }

    @Override // s1.h
    public void accept(Object obj) {
        ((z0) obj).f9262b.release();
    }

    @Override // j7.e
    public Object apply(Object obj) {
        c1 c1VarG;
        c1 c1VarJ;
        int i = 0;
        switch (this.f6471u) {
            case 1:
                Cursor cursorRawQuery = ((SQLiteDatabase) obj).rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]);
                try {
                    ArrayList arrayList = new ArrayList();
                    while (cursorRawQuery.moveToNext()) {
                        a7.b bVarA = j.a();
                        bVarA.E(cursorRawQuery.getString(1));
                        bVarA.f619w = m7.a.b(cursorRawQuery.getInt(2));
                        String string = cursorRawQuery.getString(3);
                        bVarA.f618v = string == null ? null : Base64.decode(string, 0);
                        arrayList.add(bVarA.k());
                        break;
                    }
                    return arrayList;
                } finally {
                    cursorRawQuery.close();
                }
            case 2:
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            default:
                return Integer.valueOf(((r1.b) obj).f11268r);
            case 3:
                return j0.v(Integer.valueOf(((i) obj).f10154u));
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return ((o) obj).a().getClass().getSimpleName();
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return j0.r(q.v(((b0) obj).p().f9179b, new b(8)));
            case 8:
                return Integer.valueOf(((g1) obj).f9764c);
            case 14:
                t tVar = (t) obj;
                return tVar.f10061a + ": " + tVar.f10062b;
            case 15:
                p1.z0 z0Var = (p1.z0) obj;
                z0Var.getClass();
                Bundle bundle = new Bundle();
                int i10 = z0Var.f10123u;
                if (i10 != 0) {
                    bundle.putInt(p1.z0.f10120x, i10);
                }
                int i11 = z0Var.f10124v;
                if (i11 != 0) {
                    bundle.putInt(p1.z0.f10121y, i11);
                }
                int i12 = z0Var.f10125w;
                if (i12 != 0) {
                    bundle.putInt(p1.z0.f10122z, i12);
                }
                return bundle;
            case 16:
                f0 f0Var = (f0) obj;
                f0Var.getClass();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(f0.f9729h, f0Var.f9735a);
                String str = f0Var.f9736b;
                if (str != null) {
                    bundle2.putString(f0.i, str);
                }
                String str2 = f0Var.f9737c;
                if (str2 != null) {
                    bundle2.putString(f0.f9730j, str2);
                }
                int i13 = f0Var.f9738d;
                if (i13 != 0) {
                    bundle2.putInt(f0.f9731k, i13);
                }
                int i14 = f0Var.f9739e;
                if (i14 != 0) {
                    bundle2.putInt(f0.f9732l, i14);
                }
                String str3 = f0Var.f;
                if (str3 != null) {
                    bundle2.putString(f0.f9733m, str3);
                }
                String str4 = f0Var.f9740g;
                if (str4 != null) {
                    bundle2.putString(f0.f9734n, str4);
                }
                return bundle2;
            case 17:
                Bundle bundle3 = (Bundle) obj;
                Uri uri = (Uri) bundle3.getParcelable(f0.f9729h);
                uri.getClass();
                String string2 = bundle3.getString(f0.i);
                String string3 = bundle3.getString(f0.f9730j);
                int i15 = bundle3.getInt(f0.f9731k, 0);
                int i16 = bundle3.getInt(f0.f9732l, 0);
                String string4 = bundle3.getString(f0.f9733m);
                String string5 = bundle3.getString(f0.f9734n);
                na.a aVar = new na.a();
                aVar.f8876d = uri;
                aVar.f8873a = m0.p(string2);
                aVar.f8877e = string3;
                aVar.f8874b = i15;
                aVar.f8875c = i16;
                aVar.f = string4;
                aVar.f8878g = string5;
                return new f0(aVar);
            case 18:
                Bundle bundle4 = (Bundle) obj;
                p1.q qVar = p1.q.Q;
                p pVar = new p();
                if (bundle4 != null) {
                    ClassLoader classLoader = s1.d.class.getClassLoader();
                    int i17 = s1.b0.f11647a;
                    bundle4.setClassLoader(classLoader);
                }
                String string6 = bundle4.getString(p1.q.R);
                String str5 = qVar.f10012a;
                if (string6 == null) {
                    string6 = str5;
                }
                pVar.f9957a = string6;
                String string7 = bundle4.getString(p1.q.S);
                String str6 = qVar.f10013b;
                if (string7 == null) {
                    string7 = str6;
                }
                pVar.f9958b = string7;
                ArrayList parcelableArrayList = bundle4.getParcelableArrayList(p1.q.f10008w0);
                if (parcelableArrayList == null) {
                    c1VarG = c1.f650y;
                } else {
                    g0 g0VarN = j0.n();
                    for (int i18 = 0; i18 < parcelableArrayList.size(); i18++) {
                        Bundle bundle5 = (Bundle) parcelableArrayList.get(i18);
                        bundle5.getClass();
                        String string8 = bundle5.getString(t.f10059c);
                        String string9 = bundle5.getString(t.f10060d);
                        string9.getClass();
                        g0VarN.a(new t(string8, string9));
                    }
                    c1VarG = g0VarN.g();
                }
                pVar.f9959c = j0.r(c1VarG);
                String string10 = bundle4.getString(p1.q.T);
                String str7 = qVar.f10015d;
                if (string10 == null) {
                    string10 = str7;
                }
                pVar.f9960d = string10;
                pVar.f9961e = bundle4.getInt(p1.q.U, qVar.f10016e);
                pVar.f = bundle4.getInt(p1.q.V, qVar.f);
                pVar.f9962g = bundle4.getInt(p1.q.f10009x0, qVar.f10017g);
                pVar.f9963h = bundle4.getInt(p1.q.W, qVar.f10018h);
                pVar.i = bundle4.getInt(p1.q.X, qVar.i);
                String string11 = bundle4.getString(p1.q.Y);
                String str8 = qVar.f10020k;
                if (string11 == null) {
                    string11 = str8;
                }
                pVar.f9964j = string11;
                String string12 = bundle4.getString(p1.q.Z);
                String str9 = qVar.f10022m;
                if (string12 == null) {
                    string12 = str9;
                }
                pVar.f9966l = m0.p(string12);
                String string13 = bundle4.getString(p1.q.f9987a0);
                String str10 = qVar.f10023n;
                if (string13 == null) {
                    string13 = str10;
                }
                pVar.f9967m = m0.p(string13);
                pVar.f9968n = bundle4.getInt(p1.q.f9988b0, qVar.f10024o);
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    byte[] byteArray = bundle4.getByteArray(p1.q.f9989c0 + "_" + Integer.toString(i, 36));
                    if (byteArray == null) {
                        pVar.f9970p = arrayList2;
                        pVar.f9971q = (m) bundle4.getParcelable(p1.q.f9990d0);
                        pVar.f9972r = bundle4.getLong(p1.q.f9991e0, qVar.f10028s);
                        pVar.f9974t = bundle4.getInt(p1.q.f9992f0, qVar.f10030u);
                        pVar.f9975u = bundle4.getInt(p1.q.f9993g0, qVar.f10031v);
                        pVar.f9976v = bundle4.getInt(p1.q.f10011z0, qVar.f10032w);
                        pVar.f9977w = bundle4.getInt(p1.q.A0, qVar.f10033x);
                        pVar.f9978x = bundle4.getFloat(p1.q.f9994h0, qVar.f10034y);
                        pVar.f9979y = bundle4.getInt(p1.q.f9995i0, qVar.f10035z);
                        pVar.f9980z = bundle4.getFloat(p1.q.f9996j0, qVar.A);
                        pVar.A = bundle4.getByteArray(p1.q.f9997k0);
                        pVar.B = bundle4.getInt(p1.q.l0, qVar.C);
                        pVar.D = bundle4.getInt(p1.q.f10010y0, qVar.E);
                        Bundle bundle6 = bundle4.getBundle(p1.q.f9998m0);
                        if (bundle6 != null) {
                            pVar.C = new p1.h(bundle6.getInt(p1.h.i, -1), bundle6.getInt(p1.h.f9768j, -1), bundle6.getInt(p1.h.f9769k, -1), bundle6.getByteArray(p1.h.f9770l), bundle6.getInt(p1.h.f9771m, -1), bundle6.getInt(p1.h.f9772n, -1));
                        }
                        pVar.E = bundle4.getInt(p1.q.f9999n0, qVar.F);
                        pVar.F = bundle4.getInt(p1.q.f10000o0, qVar.G);
                        pVar.G = bundle4.getInt(p1.q.f10001p0, qVar.H);
                        pVar.H = bundle4.getInt(p1.q.f10002q0, qVar.I);
                        pVar.I = bundle4.getInt(p1.q.f10003r0, qVar.J);
                        pVar.J = bundle4.getInt(p1.q.f10004s0, qVar.K);
                        pVar.L = bundle4.getInt(p1.q.f10006u0, qVar.M);
                        pVar.M = bundle4.getInt(p1.q.f10007v0, qVar.N);
                        pVar.N = bundle4.getInt(p1.q.f10005t0, qVar.O);
                        return new p1.q(pVar);
                    }
                    arrayList2.add(byteArray);
                    i++;
                }
                break;
            case 19:
                Bundle bundle7 = (Bundle) obj;
                Bundle bundle8 = bundle7.getBundle(h1.f9781c);
                bundle8.getClass();
                ArrayList parcelableArrayList2 = bundle8.getParcelableArrayList(g1.f);
                if (parcelableArrayList2 == null) {
                    h0 h0Var = j0.f690v;
                    c1VarJ = c1.f650y;
                } else {
                    c1VarJ = s1.d.j(new b(18), parcelableArrayList2);
                }
                g1 g1Var = new g1(bundle8.getString(g1.f9761g, ""), (p1.q[]) c1VarJ.toArray(new p1.q[0]));
                int[] intArray = bundle7.getIntArray(h1.f9782d);
                intArray.getClass();
                return new h1(g1Var, c.c(intArray));
            case 20:
                m1 m1Var = (m1) obj;
                m1Var.getClass();
                Bundle bundle9 = new Bundle();
                bundle9.putBundle(m1.f, m1Var.f9944b.c());
                bundle9.putIntArray(m1.f9941g, m1Var.f9946d);
                bundle9.putBooleanArray(m1.f9942h, m1Var.f9947e);
                bundle9.putBoolean(m1.i, m1Var.f9945c);
                return bundle9;
            case 26:
                return Long.valueOf(((t3.a) obj).f12072b);
            case 27:
                return Long.valueOf(((t3.a) obj).f12073c);
            case 28:
                return (r) obj;
        }
    }

    @Override // na.e
    public Object e(zc.c cVar) {
        switch (this.f6471u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return AbtRegistrar.lambda$getComponents$0(cVar);
            case 9:
                return (ScheduledExecutorService) ExecutorsRegistrar.f3562a.get();
            case 10:
                return (ScheduledExecutorService) ExecutorsRegistrar.f3564c.get();
            case 11:
                return (ScheduledExecutorService) ExecutorsRegistrar.f3563b.get();
            case 12:
                n nVar = ExecutorsRegistrar.f3562a;
                return oa.j.f9477u;
            default:
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(cVar);
        }
    }

    @Override // o8.d
    public void t(Exception exc) {
        Log.e("FirebaseCrashlytics", "Error fetching settings.", exc);
    }

    @Override // nb.a
    public void c(nb.b bVar) {
    }
}
