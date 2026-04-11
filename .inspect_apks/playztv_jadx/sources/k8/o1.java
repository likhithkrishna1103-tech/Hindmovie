package k8;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.i7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o1 extends com.google.android.gms.internal.measurement.i0 implements h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x3 f7348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f7349e;
    public String f;

    public o1(x3 x3Var) {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
        t7.v.h(x3Var);
        this.f7348d = x3Var;
        this.f = null;
    }

    @Override // k8.h0
    public final void A(a4 a4Var) {
        t7.v.d(a4Var.f7076u);
        t7.v.h(a4Var.P);
        q1 q1Var = new q1(1);
        q1Var.f7381v = this;
        q1Var.f7382w = a4Var;
        e(q1Var);
    }

    @Override // k8.h0
    public final void C(long j5, String str, String str2, String str3) {
        G(new r1(this, str2, str3, str, j5, 0));
    }

    @Override // k8.h0
    public final List D(String str, String str2, String str3) {
        f(str, true);
        x3 x3Var = this.f7348d;
        try {
            return (List) x3Var.x().u1(new s1(this, str, str2, str3, 2)).get();
        } catch (InterruptedException | ExecutionException e10) {
            x3Var.g().A.c(e10, "Failed to get conditional user properties as");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // k8.h0
    public final void E(v vVar, a4 a4Var) {
        t7.v.h(vVar);
        H(a4Var);
        G(new ab.c(this, vVar, a4Var, 2));
    }

    @Override // k8.h0
    public final void F(a4 a4Var) {
        H(a4Var);
        G(new q1(this, a4Var, 4));
    }

    public final void G(Runnable runnable) {
        x3 x3Var = this.f7348d;
        if (x3Var.x().A1()) {
            runnable.run();
        } else {
            x3Var.x().y1(runnable);
        }
    }

    public final void H(a4 a4Var) {
        t7.v.h(a4Var);
        String str = a4Var.f7076u;
        t7.v.d(str);
        f(str, false);
        this.f7348d.c0().a2(a4Var.f7077v, a4Var.K);
    }

    public final void I(v vVar, a4 a4Var) {
        x3 x3Var = this.f7348d;
        x3Var.d0();
        x3Var.v(vVar, a4Var);
    }

    @Override // com.google.android.gms.internal.measurement.i0
    public final boolean c(int i, Parcel parcel, Parcel parcel2) {
        boolean z2;
        ArrayList arrayList = null;
        x3 x3Var = this.f7348d;
        switch (i) {
            case 1:
                v vVar = (v) com.google.android.gms.internal.measurement.h0.a(parcel, v.CREATOR);
                a4 a4Var = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                E(vVar, a4Var);
                parcel2.writeNoException();
                return true;
            case 2:
                e4 e4Var = (e4) com.google.android.gms.internal.measurement.h0.a(parcel, e4.CREATOR);
                a4 a4Var2 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                n(e4Var, a4Var2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case 23:
            default:
                return false;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                a4 a4Var3 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                z(a4Var3);
                parcel2.writeNoException();
                return true;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                v vVar2 = (v) com.google.android.gms.internal.measurement.h0.a(parcel, v.CREATOR);
                String string = parcel.readString();
                parcel.readString();
                com.google.android.gms.internal.measurement.h0.d(parcel);
                t7.v.h(vVar2);
                t7.v.d(string);
                f(string, true);
                G(new ab.c(this, vVar2, string, 3));
                parcel2.writeNoException();
                return true;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                a4 a4Var4 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                y(a4Var4);
                parcel2.writeNoException();
                return true;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                a4 a4Var5 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                z2 = parcel.readInt() != 0;
                com.google.android.gms.internal.measurement.h0.d(parcel);
                H(a4Var5);
                String str = a4Var5.f7076u;
                t7.v.h(str);
                try {
                    List<f4> list = (List) x3Var.x().u1(new t1(this, 1, str)).get();
                    ArrayList arrayList2 = new ArrayList(list.size());
                    for (f4 f4Var : list) {
                        if (z2 || !h4.u2(f4Var.f7181c)) {
                            arrayList2.add(new e4(f4Var));
                        }
                        break;
                    }
                    arrayList = arrayList2;
                } catch (InterruptedException e10) {
                    e = e10;
                    x3Var.g().A.b(p0.v1(str), e, "Failed to get user properties. appId");
                } catch (ExecutionException e11) {
                    e = e11;
                    x3Var.g().A.b(p0.v1(str), e, "Failed to get user properties. appId");
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(arrayList);
                return true;
            case 9:
                v vVar3 = (v) com.google.android.gms.internal.measurement.h0.a(parcel, v.CREATOR);
                String string2 = parcel.readString();
                com.google.android.gms.internal.measurement.h0.d(parcel);
                byte[] bArrW = w(vVar3, string2);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrW);
                return true;
            case 10:
                long j5 = parcel.readLong();
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                com.google.android.gms.internal.measurement.h0.d(parcel);
                C(j5, string3, string4, string5);
                parcel2.writeNoException();
                return true;
            case 11:
                a4 a4Var6 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                String strM = m(a4Var6);
                parcel2.writeNoException();
                parcel2.writeString(strM);
                return true;
            case 12:
                d dVar = (d) com.google.android.gms.internal.measurement.h0.a(parcel, d.CREATOR);
                a4 a4Var7 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                k(dVar, a4Var7);
                parcel2.writeNoException();
                return true;
            case 13:
                d dVar2 = (d) com.google.android.gms.internal.measurement.h0.a(parcel, d.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                t7.v.h(dVar2);
                t7.v.h(dVar2.f7130w);
                t7.v.d(dVar2.f7128u);
                f(dVar2.f7128u, true);
                G(new ea.t(10, this, new d(dVar2), false));
                parcel2.writeNoException();
                return true;
            case 14:
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                ClassLoader classLoader = com.google.android.gms.internal.measurement.h0.f3033a;
                z2 = parcel.readInt() != 0;
                a4 a4Var8 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                List listR = r(string6, string7, z2, a4Var8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listR);
                return true;
            case 15:
                String string8 = parcel.readString();
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                ClassLoader classLoader2 = com.google.android.gms.internal.measurement.h0.f3033a;
                z2 = parcel.readInt() != 0;
                com.google.android.gms.internal.measurement.h0.d(parcel);
                List listP = p(string8, string9, string10, z2);
                parcel2.writeNoException();
                parcel2.writeTypedList(listP);
                return true;
            case 16:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                a4 a4Var9 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                List listT = t(string11, string12, a4Var9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listT);
                return true;
            case 17:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                com.google.android.gms.internal.measurement.h0.d(parcel);
                List listD = D(string13, string14, string15);
                parcel2.writeNoException();
                parcel2.writeTypedList(listD);
                return true;
            case 18:
                a4 a4Var10 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                x(a4Var10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.h0.a(parcel, Bundle.CREATOR);
                a4 a4Var11 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                mo2g(bundle, a4Var11);
                parcel2.writeNoException();
                return true;
            case 20:
                a4 a4Var12 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                i(a4Var12);
                parcel2.writeNoException();
                return true;
            case 21:
                a4 a4Var13 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                g gVarU = u(a4Var13);
                parcel2.writeNoException();
                if (gVarU == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                gVarU.writeToParcel(parcel2, 1);
                return true;
            case 24:
                a4 a4Var14 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                Bundle bundle2 = (Bundle) com.google.android.gms.internal.measurement.h0.a(parcel, Bundle.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                List listG = g(bundle2, a4Var14);
                parcel2.writeNoException();
                parcel2.writeTypedList(listG);
                return true;
            case 25:
                a4 a4Var15 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                o(a4Var15);
                parcel2.writeNoException();
                return true;
            case 26:
                a4 a4Var16 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                A(a4Var16);
                parcel2.writeNoException();
                return true;
            case 27:
                a4 a4Var17 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                F(a4Var17);
                parcel2.writeNoException();
                return true;
            case 28:
                Bundle bundle3 = (Bundle) com.google.android.gms.internal.measurement.h0.a(parcel, Bundle.CREATOR);
                a4 a4Var18 = (a4) com.google.android.gms.internal.measurement.h0.a(parcel, a4.CREATOR);
                com.google.android.gms.internal.measurement.h0.d(parcel);
                i7.f3057v.get();
                if (x3Var.S().A1(null, w.f7481g1)) {
                    H(a4Var18);
                    String str2 = a4Var18.f7076u;
                    t7.v.h(str2);
                    p1 p1Var = new p1(0);
                    p1Var.f7366v = this;
                    p1Var.f7367w = bundle3;
                    p1Var.f7368x = str2;
                    G(p1Var);
                }
                parcel2.writeNoException();
                return true;
        }
    }

    public final void e(Runnable runnable) {
        x3 x3Var = this.f7348d;
        if (x3Var.x().A1()) {
            runnable.run();
        } else {
            x3Var.x().z1(runnable);
        }
    }

    public final void f(String str, boolean z2) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        x3 x3Var = this.f7348d;
        if (zIsEmpty) {
            x3Var.g().A.d("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z2) {
            try {
                if (this.f7349e == null) {
                    this.f7349e = Boolean.valueOf("com.google.android.gms".equals(this.f) || x7.b.e(x3Var.F.f7282u, Binder.getCallingUid()) || q7.h.b(x3Var.F.f7282u).c(Binder.getCallingUid()));
                }
                if (this.f7349e.booleanValue()) {
                    return;
                }
            } catch (SecurityException e10) {
                x3Var.g().A.c(p0.v1(str), "Measurement Service called with invalid calling package. appId");
                throw e10;
            }
        }
        if (this.f == null) {
            Context context = x3Var.F.f7282u;
            int callingUid = Binder.getCallingUid();
            int i = q7.g.f11045e;
            if (x7.b.g(callingUid, context, str)) {
                this.f = str;
            }
        }
        if (str.equals(this.f)) {
            return;
        }
        throw new SecurityException("Unknown calling package name '" + str + "'.");
    }

    @Override // k8.h0
    public final List g(Bundle bundle, a4 a4Var) {
        H(a4Var);
        String str = a4Var.f7076u;
        t7.v.h(str);
        x3 x3Var = this.f7348d;
        try {
            return (List) x3Var.x().u1(new u1(this, a4Var, bundle)).get();
        } catch (InterruptedException | ExecutionException e10) {
            x3Var.g().A.b(p0.v1(str), e10, "Failed to get trigger URIs. appId");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // k8.h0
    public final void i(a4 a4Var) {
        t7.v.d(a4Var.f7076u);
        t7.v.h(a4Var.P);
        e(new q1(this, a4Var, 5));
    }

    @Override // k8.h0
    public final void k(d dVar, a4 a4Var) {
        t7.v.h(dVar);
        t7.v.h(dVar.f7130w);
        H(a4Var);
        d dVar2 = new d(dVar);
        dVar2.f7128u = a4Var.f7076u;
        G(new ab.c(this, dVar2, a4Var, 1));
    }

    @Override // k8.h0
    public final String m(a4 a4Var) {
        H(a4Var);
        x3 x3Var = this.f7348d;
        try {
            return (String) x3Var.x().u1(new t1(x3Var, 2, a4Var)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            x3Var.g().A.b(p0.v1(a4Var.f7076u), e10, "Failed to get app instance id. appId");
            return null;
        }
    }

    @Override // k8.h0
    public final void n(e4 e4Var, a4 a4Var) {
        t7.v.h(e4Var);
        H(a4Var);
        G(new ab.c(this, e4Var, a4Var, 4));
    }

    @Override // k8.h0
    public final void o(a4 a4Var) {
        t7.v.d(a4Var.f7076u);
        t7.v.h(a4Var.P);
        q1 q1Var = new q1(0);
        q1Var.f7381v = this;
        q1Var.f7382w = a4Var;
        e(q1Var);
    }

    @Override // k8.h0
    public final List p(String str, String str2, String str3, boolean z2) {
        f(str, true);
        x3 x3Var = this.f7348d;
        try {
            List<f4> list = (List) x3Var.x().u1(new s1(this, str, str2, str3, 0)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (f4 f4Var : list) {
                if (z2 || !h4.u2(f4Var.f7181c)) {
                    arrayList.add(new e4(f4Var));
                }
            }
            return arrayList;
        } catch (InterruptedException e10) {
            e = e10;
            x3Var.g().A.b(p0.v1(str), e, "Failed to get user properties as. appId");
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e11) {
            e = e11;
            x3Var.g().A.b(p0.v1(str), e, "Failed to get user properties as. appId");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // k8.h0
    public final List r(String str, String str2, boolean z2, a4 a4Var) {
        H(a4Var);
        String str3 = a4Var.f7076u;
        t7.v.h(str3);
        x3 x3Var = this.f7348d;
        try {
            List<f4> list = (List) x3Var.x().u1(new s1(this, str3, str, str2, 1)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (f4 f4Var : list) {
                if (z2 || !h4.u2(f4Var.f7181c)) {
                    arrayList.add(new e4(f4Var));
                }
            }
            return arrayList;
        } catch (InterruptedException e10) {
            e = e10;
            x3Var.g().A.b(p0.v1(str3), e, "Failed to query user properties. appId");
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e11) {
            e = e11;
            x3Var.g().A.b(p0.v1(str3), e, "Failed to query user properties. appId");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // k8.h0
    public final List t(String str, String str2, a4 a4Var) {
        H(a4Var);
        String str3 = a4Var.f7076u;
        t7.v.h(str3);
        x3 x3Var = this.f7348d;
        try {
            return (List) x3Var.x().u1(new s1(this, str3, str, str2, 3)).get();
        } catch (InterruptedException | ExecutionException e10) {
            x3Var.g().A.c(e10, "Failed to get conditional user properties");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // k8.h0
    public final g u(a4 a4Var) {
        H(a4Var);
        String str = a4Var.f7076u;
        t7.v.d(str);
        x3 x3Var = this.f7348d;
        try {
            return (g) x3Var.x().x1(new t1(this, 0, a4Var)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            x3Var.g().A.b(p0.v1(str), e10, "Failed to get consent. appId");
            return new g(null);
        }
    }

    @Override // k8.h0
    public final byte[] w(v vVar, String str) {
        t7.v.d(str);
        t7.v.h(vVar);
        f(str, true);
        x3 x3Var = this.f7348d;
        r0 r0Var = x3Var.g().H;
        k1 k1Var = x3Var.F;
        l0 l0Var = k1Var.G;
        String str2 = vVar.f7444u;
        r0Var.c(l0Var.b(str2), "Log and bundle. event");
        x3Var.y0().getClass();
        long jNanoTime = System.nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) x3Var.x().x1(new f1(this, vVar, str)).get();
            if (bArr == null) {
                x3Var.g().A.c(p0.v1(str), "Log and bundle returned null. appId");
                bArr = new byte[0];
            }
            x3Var.y0().getClass();
            x3Var.g().H.e("Log and bundle processed. event, size, time_ms", k1Var.G.b(str2), Integer.valueOf(bArr.length), Long.valueOf((System.nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException e10) {
            e = e10;
            x3Var.g().A.e("Failed to log and bundle. appId, event, error", p0.v1(str), k1Var.G.b(str2), e);
            return null;
        } catch (ExecutionException e11) {
            e = e11;
            x3Var.g().A.e("Failed to log and bundle. appId, event, error", p0.v1(str), k1Var.G.b(str2), e);
            return null;
        }
    }

    @Override // k8.h0
    public final void x(a4 a4Var) {
        t7.v.d(a4Var.f7076u);
        f(a4Var.f7076u, false);
        G(new q1(this, a4Var, 6));
    }

    @Override // k8.h0
    public final void y(a4 a4Var) {
        H(a4Var);
        G(new q1(this, a4Var, 3));
    }

    @Override // k8.h0
    public final void z(a4 a4Var) {
        H(a4Var);
        G(new q1(this, a4Var, 2));
    }

    @Override // k8.h0
    /* JADX INFO: renamed from: g */
    public final void mo2g(Bundle bundle, a4 a4Var) {
        H(a4Var);
        String str = a4Var.f7076u;
        t7.v.h(str);
        p1 p1Var = new p1(1);
        p1Var.f7366v = this;
        p1Var.f7367w = bundle;
        p1Var.f7368x = str;
        G(p1Var);
    }
}
