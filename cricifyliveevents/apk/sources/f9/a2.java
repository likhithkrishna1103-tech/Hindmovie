package f9;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a2 extends com.google.android.gms.internal.measurement.x implements i0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q4 f4001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f4002e;
    public String f;

    public a2(q4 q4Var) {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
        o8.u.g(q4Var);
        this.f4001d = q4Var;
        this.f = null;
    }

    @Override // f9.i0
    public final i A(w4 w4Var) {
        f(w4Var);
        String str = w4Var.f4462v;
        o8.u.d(str);
        q4 q4Var = this.f4001d;
        try {
            return (i) q4Var.a0().u1(new s1(this, w4Var, 1)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e9) {
            q4Var.C().B.c(w0.u1(str), e9, "Failed to get consent. appId");
            return new i(null);
        }
    }

    @Override // f9.i0
    public final List B(String str, String str2, String str3) {
        L(str, true);
        q4 q4Var = this.f4001d;
        try {
            return (List) q4Var.a0().t1(new w1(this, str, str2, str3, 3)).get();
        } catch (InterruptedException | ExecutionException e9) {
            q4Var.C().B.b(e9, "Failed to get conditional user properties as");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // f9.i0
    public final void C(Bundle bundle, w4 w4Var) {
        f(w4Var);
        String str = w4Var.f4462v;
        o8.u.g(str);
        M(new z1(this, bundle, str, w4Var));
    }

    @Override // f9.i0
    public final void D(w4 w4Var, d dVar) {
        f(w4Var);
        M(new v1((Object) this, w4Var, (Object) dVar, 4));
    }

    @Override // f9.i0
    public final void G(w4 w4Var) {
        f(w4Var);
        M(new t1(this, w4Var, 0));
    }

    @Override // f9.i0
    public final void H(s4 s4Var, w4 w4Var) {
        o8.u.g(s4Var);
        f(w4Var);
        M(new v1(this, s4Var, w4Var, 3));
    }

    @Override // f9.i0
    public final void I(v vVar, w4 w4Var) {
        o8.u.g(vVar);
        f(w4Var);
        M(new v1(this, vVar, w4Var, 1));
    }

    @Override // f9.i0
    public final void K(w4 w4Var, Bundle bundle, k0 k0Var) {
        f(w4Var);
        String str = w4Var.f4462v;
        o8.u.g(str);
        this.f4001d.a0().v1(new y1(this, w4Var, bundle, k0Var, str));
    }

    public final void L(String str, boolean z10) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        q4 q4Var = this.f4001d;
        if (zIsEmpty) {
            q4Var.C().B.a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z10) {
            try {
                if (this.f4002e == null) {
                    boolean z11 = true;
                    if (!"com.google.android.gms".equals(this.f) && !s8.b.e(q4Var.G.f4363v, Binder.getCallingUid()) && !l8.i.b(q4Var.G.f4363v).c(Binder.getCallingUid())) {
                        z11 = false;
                    }
                    this.f4002e = Boolean.valueOf(z11);
                }
                if (this.f4002e.booleanValue()) {
                    return;
                }
            } catch (SecurityException e9) {
                q4Var.C().B.b(w0.u1(str), "Measurement Service called with invalid calling package. appId");
                throw e9;
            }
        }
        if (this.f == null) {
            Context context = q4Var.G.f4363v;
            int callingUid = Binder.getCallingUid();
            AtomicBoolean atomicBoolean = l8.g.f7891a;
            if (s8.b.g(callingUid, context, str)) {
                this.f = str;
            }
        }
        if (str.equals(this.f)) {
            return;
        }
        throw new SecurityException("Unknown calling package name '" + str + "'.");
    }

    public final void M(Runnable runnable) {
        q4 q4Var = this.f4001d;
        if (q4Var.a0().s1()) {
            runnable.run();
        } else {
            q4Var.a0().v1(runnable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.x
    public final boolean b(int i, Parcel parcel, Parcel parcel2) {
        boolean z10;
        List list;
        q4 q4Var = this.f4001d;
        ArrayList arrayList = null;
        k0 j0Var = null;
        m0 l0Var = null;
        switch (i) {
            case 1:
                v vVar = (v) com.google.android.gms.internal.measurement.y.a(parcel, v.CREATOR);
                w4 w4Var = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                I(vVar, w4Var);
                parcel2.writeNoException();
                return true;
            case 2:
                s4 s4Var = (s4) com.google.android.gms.internal.measurement.y.a(parcel, s4.CREATOR);
                w4 w4Var2 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                H(s4Var, w4Var2);
                parcel2.writeNoException();
                return true;
            case 3:
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
            case 22:
            case 23:
            case 28:
            default:
                return false;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                w4 w4Var3 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                G(w4Var3);
                parcel2.writeNoException();
                return true;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                v vVar2 = (v) com.google.android.gms.internal.measurement.y.a(parcel, v.CREATOR);
                String string = parcel.readString();
                parcel.readString();
                com.google.android.gms.internal.measurement.y.d(parcel);
                o8.u.g(vVar2);
                o8.u.d(string);
                L(string, true);
                M(new v1(this, vVar2, string, 2));
                parcel2.writeNoException();
                return true;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                w4 w4Var4 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                q(w4Var4);
                parcel2.writeNoException();
                return true;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                w4 w4Var5 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                Object[] objArr = parcel.readInt() != 0;
                com.google.android.gms.internal.measurement.y.d(parcel);
                f(w4Var5);
                String str = w4Var5.f4462v;
                o8.u.g(str);
                try {
                    List<t4> list2 = (List) q4Var.a0().t1(new s1(this, str, 0)).get();
                    ArrayList arrayList2 = new ArrayList(list2.size());
                    for (t4 t4Var : list2) {
                        if (objArr != false || !u4.L1(t4Var.f4423c)) {
                            arrayList2.add(new s4(t4Var));
                        }
                        break;
                    }
                    arrayList = arrayList2;
                } catch (InterruptedException e9) {
                    e = e9;
                    q4Var.C().B.c(w0.u1(str), e, "Failed to get user properties. appId");
                } catch (ExecutionException e10) {
                    e = e10;
                    q4Var.C().B.c(w0.u1(str), e, "Failed to get user properties. appId");
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(arrayList);
                return true;
            case 9:
                v vVar3 = (v) com.google.android.gms.internal.measurement.y.a(parcel, v.CREATOR);
                String string2 = parcel.readString();
                com.google.android.gms.internal.measurement.y.d(parcel);
                byte[] bArrR = r(vVar3, string2);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrR);
                return true;
            case 10:
                long j4 = parcel.readLong();
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                com.google.android.gms.internal.measurement.y.d(parcel);
                w(j4, string3, string4, string5);
                parcel2.writeNoException();
                return true;
            case 11:
                w4 w4Var6 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                String strV = v(w4Var6);
                parcel2.writeNoException();
                parcel2.writeString(strV);
                return true;
            case 12:
                e eVar = (e) com.google.android.gms.internal.measurement.y.a(parcel, e.CREATOR);
                w4 w4Var7 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                l(eVar, w4Var7);
                parcel2.writeNoException();
                return true;
            case 13:
                e eVar2 = (e) com.google.android.gms.internal.measurement.y.a(parcel, e.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                o8.u.g(eVar2);
                o8.u.g(eVar2.f4085x);
                o8.u.d(eVar2.f4083v);
                L(eVar2.f4083v, true);
                M(new ya.s(6, this, new e(eVar2), false));
                parcel2.writeNoException();
                return true;
            case 14:
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                ClassLoader classLoader = com.google.android.gms.internal.measurement.y.f2729a;
                z10 = parcel.readInt() != 0;
                w4 w4Var8 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                List listK = k(string6, string7, z10, w4Var8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listK);
                return true;
            case 15:
                String string8 = parcel.readString();
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                ClassLoader classLoader2 = com.google.android.gms.internal.measurement.y.f2729a;
                z10 = parcel.readInt() != 0;
                com.google.android.gms.internal.measurement.y.d(parcel);
                List listI = i(string8, string9, string10, z10);
                parcel2.writeNoException();
                parcel2.writeTypedList(listI);
                return true;
            case 16:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                w4 w4Var9 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                List listN = n(string11, string12, w4Var9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listN);
                return true;
            case 17:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                com.google.android.gms.internal.measurement.y.d(parcel);
                List listB = B(string13, string14, string15);
                parcel2.writeNoException();
                parcel2.writeTypedList(listB);
                return true;
            case 18:
                w4 w4Var10 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                o(w4Var10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.y.a(parcel, Bundle.CREATOR);
                w4 w4Var11 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                C(bundle, w4Var11);
                parcel2.writeNoException();
                return true;
            case 20:
                w4 w4Var12 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                s(w4Var12);
                parcel2.writeNoException();
                return true;
            case 21:
                w4 w4Var13 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                i iVarA = A(w4Var13);
                parcel2.writeNoException();
                if (iVarA == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                iVarA.writeToParcel(parcel2, 1);
                return true;
            case 24:
                w4 w4Var14 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                Bundle bundle2 = (Bundle) com.google.android.gms.internal.measurement.y.a(parcel, Bundle.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                f(w4Var14);
                String str2 = w4Var14.f4462v;
                o8.u.g(str2);
                if (!q4Var.Z().w1(null, f0.Z0)) {
                    try {
                        list = (List) q4Var.a0().t1(new x1(this, w4Var14, bundle2, 1)).get();
                    } catch (InterruptedException | ExecutionException e11) {
                        q4Var.C().B.c(w0.u1(str2), e11, "Failed to get trigger URIs. appId");
                        list = Collections.EMPTY_LIST;
                    }
                    break;
                } else {
                    try {
                        list = (List) q4Var.a0().u1(new x1(this, w4Var14, bundle2, 0)).get(10000L, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException | ExecutionException | TimeoutException e12) {
                        q4Var.C().B.c(w0.u1(str2), e12, "Failed to get trigger URIs. appId");
                        list = Collections.EMPTY_LIST;
                    }
                    break;
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(list);
                return true;
            case 25:
                w4 w4Var15 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                h(w4Var15);
                parcel2.writeNoException();
                return true;
            case 26:
                w4 w4Var16 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                p(w4Var16);
                parcel2.writeNoException();
                return true;
            case 27:
                w4 w4Var17 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                m(w4Var17);
                parcel2.writeNoException();
                return true;
            case 29:
                w4 w4Var18 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                j4 j4Var = (j4) com.google.android.gms.internal.measurement.y.a(parcel, j4.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    l0Var = iInterfaceQueryLocalInterface instanceof m0 ? (m0) iInterfaceQueryLocalInterface : new l0(strongBinder, "com.google.android.gms.measurement.internal.IUploadBatchesCallback", 1);
                }
                com.google.android.gms.internal.measurement.y.d(parcel);
                z(w4Var18, j4Var, l0Var);
                parcel2.writeNoException();
                return true;
            case 30:
                w4 w4Var19 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                d dVar = (d) com.google.android.gms.internal.measurement.y.a(parcel, d.CREATOR);
                com.google.android.gms.internal.measurement.y.d(parcel);
                D(w4Var19, dVar);
                parcel2.writeNoException();
                return true;
            case 31:
                w4 w4Var20 = (w4) com.google.android.gms.internal.measurement.y.a(parcel, w4.CREATOR);
                Bundle bundle3 = (Bundle) com.google.android.gms.internal.measurement.y.a(parcel, Bundle.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    j0Var = iInterfaceQueryLocalInterface2 instanceof k0 ? (k0) iInterfaceQueryLocalInterface2 : new j0(strongBinder2, "com.google.android.gms.measurement.internal.ITriggerUrisCallback", 1);
                }
                com.google.android.gms.internal.measurement.y.d(parcel);
                K(w4Var20, bundle3, j0Var);
                parcel2.writeNoException();
                return true;
        }
    }

    public final void e(Runnable runnable) {
        q4 q4Var = this.f4001d;
        if (q4Var.a0().s1()) {
            runnable.run();
        } else {
            q4Var.a0().x1(runnable);
        }
    }

    public final void f(w4 w4Var) {
        o8.u.g(w4Var);
        String str = w4Var.f4462v;
        o8.u.d(str);
        L(str, false);
        this.f4001d.h0().q1(w4Var.f4463w);
    }

    @Override // f9.i0
    public final void h(w4 w4Var) {
        o8.u.d(w4Var.f4462v);
        o8.u.g(w4Var.N);
        e(new t1(this, w4Var, 6));
    }

    @Override // f9.i0
    public final List i(String str, String str2, String str3, boolean z10) {
        L(str, true);
        q4 q4Var = this.f4001d;
        try {
            List<t4> list = (List) q4Var.a0().t1(new w1(this, str, str2, str3, 1)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (t4 t4Var : list) {
                if (z10 || !u4.L1(t4Var.f4423c)) {
                    arrayList.add(new s4(t4Var));
                }
            }
            return arrayList;
        } catch (InterruptedException e9) {
            e = e9;
            q4Var.C().B.c(w0.u1(str), e, "Failed to get user properties as. appId");
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e10) {
            e = e10;
            q4Var.C().B.c(w0.u1(str), e, "Failed to get user properties as. appId");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // f9.i0
    public final List k(String str, String str2, boolean z10, w4 w4Var) {
        f(w4Var);
        String str3 = w4Var.f4462v;
        o8.u.g(str3);
        q4 q4Var = this.f4001d;
        try {
            List<t4> list = (List) q4Var.a0().t1(new w1(this, str3, str, str2, 0)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (t4 t4Var : list) {
                if (z10 || !u4.L1(t4Var.f4423c)) {
                    arrayList.add(new s4(t4Var));
                }
            }
            return arrayList;
        } catch (InterruptedException e9) {
            e = e9;
            q4Var.C().B.c(w0.u1(str3), e, "Failed to query user properties. appId");
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e10) {
            e = e10;
            q4Var.C().B.c(w0.u1(str3), e, "Failed to query user properties. appId");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // f9.i0
    public final void l(e eVar, w4 w4Var) {
        o8.u.g(eVar);
        o8.u.g(eVar.f4085x);
        f(w4Var);
        e eVar2 = new e(eVar);
        eVar2.f4083v = w4Var.f4462v;
        M(new v1(this, eVar2, w4Var, 0));
    }

    @Override // f9.i0
    public final void m(w4 w4Var) {
        f(w4Var);
        M(new t1(this, w4Var, 1));
    }

    @Override // f9.i0
    public final List n(String str, String str2, w4 w4Var) {
        f(w4Var);
        String str3 = w4Var.f4462v;
        o8.u.g(str3);
        q4 q4Var = this.f4001d;
        try {
            return (List) q4Var.a0().t1(new w1(this, str3, str, str2, 2)).get();
        } catch (InterruptedException | ExecutionException e9) {
            q4Var.C().B.b(e9, "Failed to get conditional user properties");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // f9.i0
    public final void o(w4 w4Var) {
        String str = w4Var.f4462v;
        o8.u.d(str);
        L(str, false);
        M(new t1(this, w4Var, 3));
    }

    @Override // f9.i0
    public final void p(w4 w4Var) {
        o8.u.d(w4Var.f4462v);
        o8.u.g(w4Var.N);
        e(new t1(this, w4Var, 5));
    }

    @Override // f9.i0
    public final void q(w4 w4Var) {
        f(w4Var);
        M(new t1(this, w4Var, 2));
    }

    @Override // f9.i0
    public final byte[] r(v vVar, String str) {
        o8.u.d(str);
        o8.u.g(vVar);
        L(str, true);
        q4 q4Var = this.f4001d;
        u0 u0Var = q4Var.C().I;
        r1 r1Var = q4Var.G;
        q0 q0Var = r1Var.E;
        String str2 = vVar.f4441v;
        u0Var.b(q0Var.a(str2), "Log and bundle. event");
        q4Var.A0().getClass();
        long jNanoTime = System.nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) q4Var.a0().u1(new k1(this, vVar, str)).get();
            if (bArr == null) {
                q4Var.C().B.b(w0.u1(str), "Log and bundle returned null. appId");
                bArr = new byte[0];
            }
            q4Var.A0().getClass();
            q4Var.C().I.d("Log and bundle processed. event, size, time_ms", r1Var.E.a(str2), Integer.valueOf(bArr.length), Long.valueOf((System.nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException e9) {
            e = e9;
            q4Var.C().B.d("Failed to log and bundle. appId, event, error", w0.u1(str), r1Var.E.a(str2), e);
            return null;
        } catch (ExecutionException e10) {
            e = e10;
            q4Var.C().B.d("Failed to log and bundle. appId, event, error", w0.u1(str), r1Var.E.a(str2), e);
            return null;
        }
    }

    @Override // f9.i0
    public final void s(w4 w4Var) {
        o8.u.d(w4Var.f4462v);
        o8.u.g(w4Var.N);
        e(new t1(this, w4Var, 4));
    }

    @Override // f9.i0
    public final String v(w4 w4Var) {
        f(w4Var);
        q4 q4Var = this.f4001d;
        try {
            return (String) q4Var.a0().t1(new s1(q4Var, w4Var)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e9) {
            q4Var.C().B.c(w0.u1(w4Var.f4462v), e9, "Failed to get app instance id. appId");
            return null;
        }
    }

    @Override // f9.i0
    public final void w(long j4, String str, String str2, String str3) {
        M(new u1(this, str2, str3, str, j4, 0));
    }

    @Override // f9.i0
    public final void z(w4 w4Var, j4 j4Var, m0 m0Var) {
        f(w4Var);
        String str = w4Var.f4462v;
        o8.u.g(str);
        this.f4001d.a0().v1(new z1(this, str, j4Var, m0Var, 0));
    }
}
