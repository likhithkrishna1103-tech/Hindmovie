package com.google.android.gms.internal.measurement;

import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n3 extends j5 {
    private static final n3 zzc;
    private static volatile e6 zzd;
    private String zzaa;
    private long zzab;
    private int zzac;
    private String zzad;
    private String zzae;
    private boolean zzaf;
    private s5 zzag;
    private String zzah;
    private int zzai;
    private int zzaj;
    private int zzak;
    private String zzal;
    private long zzam;
    private long zzan;
    private String zzao;
    private String zzap;
    private int zzaq;
    private String zzar;
    private o3 zzas;
    private q5 zzat;
    private long zzau;
    private long zzav;
    private String zzaw;
    private String zzax;
    private int zzay;
    private boolean zzaz;
    private String zzba;
    private boolean zzbb;
    private j3 zzbc;
    private String zzbd;
    private s5 zzbe;
    private String zzbf;
    private long zzbg;
    private boolean zzbh;
    private String zzbi;
    private boolean zzbj;
    private String zzbk;
    private int zzbl;
    private String zzbm;
    private z2 zzbn;
    private int zzbo;
    private w2 zzbp;
    private String zzbq;
    private int zze;
    private int zzf;
    private int zzg;
    private s5 zzh;
    private s5 zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private String zzo;
    private String zzp;
    private String zzq;
    private String zzr;
    private int zzs;
    private String zzt;
    private String zzu;
    private String zzv;
    private long zzw;
    private long zzx;
    private String zzy;
    private boolean zzz;

    static {
        n3 n3Var = new n3();
        zzc = n3Var;
        j5.g(n3.class, n3Var);
    }

    public n3() {
        g6 g6Var = g6.f3017y;
        this.zzh = g6Var;
        this.zzi = g6Var;
        this.zzo = "";
        this.zzp = "";
        this.zzq = "";
        this.zzr = "";
        this.zzt = "";
        this.zzu = "";
        this.zzv = "";
        this.zzy = "";
        this.zzaa = "";
        this.zzad = "";
        this.zzae = "";
        this.zzag = g6Var;
        this.zzah = "";
        this.zzal = "";
        this.zzao = "";
        this.zzap = "";
        this.zzar = "";
        this.zzat = m5.f3098y;
        this.zzaw = "";
        this.zzax = "";
        this.zzba = "";
        this.zzbd = "";
        this.zzbe = g6Var;
        this.zzbf = "";
        this.zzbi = "";
        this.zzbk = "";
        this.zzbm = "";
        this.zzbq = "";
    }

    public static /* synthetic */ void A(n3 n3Var, boolean z2) {
        n3Var.zzf |= 65536;
        n3Var.zzbh = z2;
    }

    public static /* synthetic */ void B1(n3 n3Var) {
        n3Var.zze &= -65537;
        n3Var.zzy = zzc.zzy;
    }

    public static /* synthetic */ void C1(n3 n3Var, long j5) {
        n3Var.zze |= 2;
        n3Var.zzj = j5;
    }

    public static /* synthetic */ void D1(n3 n3Var, String str) {
        str.getClass();
        n3Var.zzf |= 16384;
        n3Var.zzbf = str;
    }

    public static /* synthetic */ void F1(n3 n3Var) {
        n3Var.zzf &= -8193;
        n3Var.zzbd = zzc.zzbd;
    }

    public static /* synthetic */ void G1(n3 n3Var, String str) {
        n3Var.zze |= 16777216;
        n3Var.zzah = str;
    }

    public static /* synthetic */ void H1(n3 n3Var) {
        n3Var.zze |= 32768;
        n3Var.zzx = 106000L;
    }

    public static void I0(n3 n3Var) {
        n3Var.zzag = g6.f3017y;
    }

    public static /* synthetic */ void J0(n3 n3Var, int i) {
        n3Var.zzf |= 1048576;
        n3Var.zzbl = i;
    }

    public static /* synthetic */ void J1(n3 n3Var) {
        n3Var.zze &= -268435457;
        n3Var.zzal = zzc.zzal;
    }

    public static /* synthetic */ void K0(n3 n3Var, long j5) {
        n3Var.zze |= 524288;
        n3Var.zzab = j5;
    }

    public static /* synthetic */ void K1(n3 n3Var, String str) {
        str.getClass();
        n3Var.zze |= 4194304;
        n3Var.zzae = str;
    }

    public static /* synthetic */ void L0(n3 n3Var, String str) {
        n3Var.zze |= 262144;
        n3Var.zzaa = str;
    }

    public static void M0(n3 n3Var, ArrayList arrayList) {
        List list = n3Var.zzat;
        if (!((v4) list).f3217u) {
            n3Var.zzat = ((m5) list).c(list.size() << 1);
        }
        u4.b(arrayList, n3Var.zzat);
    }

    public static /* synthetic */ void M1(n3 n3Var, String str) {
        n3Var.zze |= 2097152;
        n3Var.zzad = str;
    }

    public static /* synthetic */ void N0(n3 n3Var, boolean z2) {
        n3Var.zze |= 131072;
        n3Var.zzz = z2;
    }

    public static /* synthetic */ void O1(n3 n3Var, String str) {
        str.getClass();
        n3Var.zze |= 128;
        n3Var.zzp = str;
    }

    public static /* synthetic */ void Q1(n3 n3Var) {
        n3Var.zze |= 64;
        n3Var.zzo = "android";
    }

    public static /* synthetic */ void R0(n3 n3Var) {
        n3Var.zze &= -257;
        n3Var.zzq = zzc.zzq;
    }

    public static /* synthetic */ void S0(n3 n3Var, int i) {
        n3Var.zze |= 33554432;
        n3Var.zzai = i;
    }

    public static /* synthetic */ void S1(n3 n3Var, String str) {
        str.getClass();
        n3Var.zze |= 65536;
        n3Var.zzy = str;
    }

    public static /* synthetic */ void T0(n3 n3Var, long j5) {
        n3Var.zzf |= 16;
        n3Var.zzau = j5;
    }

    public static /* synthetic */ void U0(n3 n3Var, String str) {
        str.getClass();
        n3Var.zze |= 2048;
        n3Var.zzt = str;
    }

    public static /* synthetic */ void U1(n3 n3Var, String str) {
        str.getClass();
        n3Var.zzf |= 8192;
        n3Var.zzbd = str;
    }

    public static void V0(n3 n3Var, Set set) {
        s5 s5Var = n3Var.zzbe;
        if (!((v4) s5Var).f3217u) {
            n3Var.zzbe = s5Var.c(s5Var.size() << 1);
        }
        u4.b(set, n3Var.zzbe);
    }

    public static /* synthetic */ void W0(n3 n3Var) {
        n3Var.zze |= 8388608;
        n3Var.zzaf = false;
    }

    public static /* synthetic */ void W1(n3 n3Var, String str) {
        str.getClass();
        n3Var.zze |= 512;
        n3Var.zzr = str;
    }

    public static /* synthetic */ void Y0(n3 n3Var) {
        n3Var.zze &= Integer.MAX_VALUE;
        n3Var.zzao = zzc.zzao;
    }

    public static /* synthetic */ void Z0(n3 n3Var, int i) {
        n3Var.zze |= 1048576;
        n3Var.zzac = i;
    }

    public static /* synthetic */ void a1(n3 n3Var, long j5) {
        n3Var.zze |= 8;
        n3Var.zzl = j5;
    }

    public static m3 a2() {
        return (m3) zzc.j();
    }

    public static /* synthetic */ void b1(n3 n3Var, String str) {
        str.getClass();
        n3Var.zze |= 8192;
        n3Var.zzv = str;
    }

    public static /* synthetic */ void d0(n3 n3Var) {
        n3Var.zze &= -262145;
        n3Var.zzaa = zzc.zzaa;
    }

    public static void d1(n3 n3Var) {
        n3Var.zzh = g6.f3017y;
    }

    public static /* synthetic */ void e0(n3 n3Var, int i) {
        n3Var.P0();
        n3Var.zzi.remove(i);
    }

    public static /* synthetic */ void e1(n3 n3Var, int i) {
        n3Var.zzf |= 8388608;
        n3Var.zzbo = i;
    }

    public static /* synthetic */ void f0(n3 n3Var, long j5) {
        n3Var.zze |= 536870912;
        n3Var.zzam = j5;
    }

    public static /* synthetic */ void f1(n3 n3Var, long j5) {
        n3Var.zze |= 16384;
        n3Var.zzw = j5;
    }

    public static /* synthetic */ void g0(n3 n3Var, String str) {
        str.getClass();
        n3Var.zze |= 4096;
        n3Var.zzu = str;
    }

    public static /* synthetic */ void g1(n3 n3Var, String str) {
        str.getClass();
        n3Var.zzf |= 131072;
        n3Var.zzbi = str;
    }

    public static /* synthetic */ void h0(n3 n3Var, ArrayList arrayList) {
        n3Var.O0();
        u4.b(arrayList, n3Var.zzh);
    }

    public static /* synthetic */ void i0(n3 n3Var, boolean z2) {
        n3Var.zzf |= 262144;
        n3Var.zzbj = z2;
    }

    public static /* synthetic */ void i1(n3 n3Var) {
        n3Var.zze &= -2097153;
        n3Var.zzad = zzc.zzad;
    }

    public static /* synthetic */ void j1(n3 n3Var, long j5) {
        n3Var.zze |= 32;
        n3Var.zzn = j5;
    }

    public static /* synthetic */ void k1(n3 n3Var, String str) {
        str.getClass();
        n3Var.zzf |= 128;
        n3Var.zzax = str;
    }

    public static /* synthetic */ void l1(n3 n3Var) {
        n3Var.zze |= 1;
        n3Var.zzg = 1;
    }

    public static /* synthetic */ void n1(n3 n3Var) {
        n3Var.zze &= -131073;
        n3Var.zzz = false;
    }

    public static /* synthetic */ void o1(n3 n3Var, int i) {
        n3Var.zzf |= 2;
        n3Var.zzaq = i;
    }

    public static m3 p(n3 n3Var) {
        i5 i5VarJ = zzc.j();
        i5VarJ.a(n3Var);
        return (m3) i5VarJ;
    }

    public static /* synthetic */ void p1(n3 n3Var, long j5) {
        n3Var.zze |= 16;
        n3Var.zzm = j5;
    }

    public static /* synthetic */ void q(n3 n3Var, int i) {
        n3Var.O0();
        n3Var.zzh.remove(i);
    }

    public static /* synthetic */ void q1(n3 n3Var, String str) {
        str.getClass();
        n3Var.zzf |= 524288;
        n3Var.zzbk = str;
    }

    public static /* synthetic */ void r(n3 n3Var, int i, f3 f3Var) {
        n3Var.O0();
        n3Var.zzh.set(i, f3Var);
    }

    public static /* synthetic */ void s(n3 n3Var, int i, u3 u3Var) {
        n3Var.P0();
        n3Var.zzi.set(i, u3Var);
    }

    public static /* synthetic */ void s1(n3 n3Var) {
        n3Var.zze &= -33;
        n3Var.zzn = 0L;
    }

    public static /* synthetic */ void t(n3 n3Var, long j5) {
        n3Var.zzf |= 32;
        n3Var.zzav = j5;
    }

    public static /* synthetic */ void t1(n3 n3Var, int i) {
        n3Var.zze |= 1024;
        n3Var.zzs = i;
    }

    public static /* synthetic */ void u(n3 n3Var, w2 w2Var) {
        n3Var.zzbp = w2Var;
        n3Var.zzf |= 16777216;
    }

    public static /* synthetic */ void u1(n3 n3Var, long j5) {
        n3Var.zze |= 4;
        n3Var.zzk = j5;
    }

    public static /* synthetic */ void v(n3 n3Var, z2 z2Var) {
        n3Var.zzbn = z2Var;
        n3Var.zzf |= 4194304;
    }

    public static /* synthetic */ void v1(n3 n3Var) {
        String str = Build.MODEL;
        str.getClass();
        n3Var.zze |= 256;
        n3Var.zzq = str;
    }

    public static /* synthetic */ void w(n3 n3Var, f3 f3Var) {
        n3Var.O0();
        n3Var.zzh.add(f3Var);
    }

    public static /* synthetic */ void x(n3 n3Var, u3 u3Var) {
        n3Var.P0();
        n3Var.zzi.add(u3Var);
    }

    public static /* synthetic */ void x1(n3 n3Var) {
        n3Var.zze &= -17;
        n3Var.zzm = 0L;
    }

    public static /* synthetic */ void y(n3 n3Var, String str) {
        str.getClass();
        n3Var.zzf |= 4;
        n3Var.zzar = str;
    }

    public static /* synthetic */ void y1(n3 n3Var, long j5) {
        n3Var.zzf |= 32768;
        n3Var.zzbg = j5;
    }

    public static void z(n3 n3Var, ArrayList arrayList) {
        s5 s5Var = n3Var.zzag;
        if (!((v4) s5Var).f3217u) {
            n3Var.zzag = s5Var.c(s5Var.size() << 1);
        }
        u4.b(arrayList, n3Var.zzag);
    }

    public static /* synthetic */ void z1(n3 n3Var, String str) {
        str.getClass();
        n3Var.zze |= Integer.MIN_VALUE;
        n3Var.zzao = str;
    }

    public final boolean A0() {
        return (this.zze & 8388608) != 0;
    }

    public final long A1() {
        return this.zzab;
    }

    public final String B() {
        return this.zzaa;
    }

    public final boolean B0() {
        return (this.zzf & 8192) != 0;
    }

    public final String C() {
        return this.zzt;
    }

    public final boolean C0() {
        return (this.zze & 4) != 0;
    }

    public final String D() {
        return this.zzv;
    }

    public final boolean D0() {
        return (this.zzf & 32768) != 0;
    }

    public final String E() {
        return this.zzbi;
    }

    public final boolean E0() {
        return (this.zze & 1024) != 0;
    }

    public final long E1() {
        return this.zzau;
    }

    public final String F() {
        return this.zzax;
    }

    public final boolean F0() {
        return (this.zze & 2) != 0;
    }

    public final String G() {
        return this.zzbk;
    }

    public final boolean G0() {
        return (this.zze & 32768) != 0;
    }

    public final String H() {
        return this.zzq;
    }

    public final int H0() {
        return this.zzac;
    }

    public final String I() {
        return this.zzao;
    }

    public final long I1() {
        return this.zzl;
    }

    public final String J() {
        return this.zzah;
    }

    public final String K() {
        return this.zzae;
    }

    public final String L() {
        return this.zzad;
    }

    public final long L1() {
        return this.zzw;
    }

    public final String M() {
        return this.zzp;
    }

    public final String N() {
        return this.zzo;
    }

    public final long N1() {
        return this.zzn;
    }

    public final String O() {
        return this.zzy;
    }

    public final void O0() {
        s5 s5Var = this.zzh;
        if (((v4) s5Var).f3217u) {
            return;
        }
        this.zzh = s5Var.c(s5Var.size() << 1);
    }

    public final String P() {
        return this.zzbd;
    }

    public final void P0() {
        s5 s5Var = this.zzi;
        if (((v4) s5Var).f3217u) {
            return;
        }
        this.zzi = s5Var.c(s5Var.size() << 1);
    }

    public final long P1() {
        return this.zzm;
    }

    public final String Q() {
        return this.zzr;
    }

    public final int Q0() {
        return this.zzbo;
    }

    public final s5 R() {
        return this.zzag;
    }

    public final long R1() {
        return this.zzk;
    }

    public final s5 S() {
        return this.zzh;
    }

    public final s5 T() {
        return this.zzi;
    }

    public final long T1() {
        return this.zzbg;
    }

    public final boolean U() {
        return this.zzbh;
    }

    public final boolean V() {
        return this.zzbj;
    }

    public final long V1() {
        return this.zzj;
    }

    public final boolean W() {
        return this.zzz;
    }

    public final boolean X() {
        return this.zzaf;
    }

    public final int X0() {
        return this.zzh.size();
    }

    public final long X1() {
        return this.zzx;
    }

    public final boolean Y() {
        return (this.zzf & 16777216) != 0;
    }

    public final w2 Y1() {
        w2 w2Var = this.zzbp;
        return w2Var == null ? w2.A() : w2Var;
    }

    public final boolean Z() {
        return (this.zze & 33554432) != 0;
    }

    public final z2 Z1() {
        z2 z2Var = this.zzbn;
        return z2Var == null ? z2.q() : z2Var;
    }

    public final boolean a0() {
        return (this.zzf & 4194304) != 0;
    }

    public final int b0() {
        return this.zzai;
    }

    public final String b2() {
        return this.zzar;
    }

    public final u3 c0(int i) {
        return (u3) this.zzi.get(i);
    }

    public final int c1() {
        return this.zzg;
    }

    public final String c2() {
        return this.zzu;
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final Object e(int i) {
        e6 k5Var;
        switch (u2.f3209a[i - 1]) {
            case 1:
                return new n3();
            case 2:
                return new m3(zzc);
            case 3:
                return new i6(zzc, "\u0004?\u0000\u0002\u0001P?\u0000\u0005\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5᠌(7ဇ)9ဈ*:ဇ+;ဉ,?ဈ-@\u001aAဈ.Cဂ/Dဇ0Gဈ1Hဇ2Iဈ3Jင4Kဈ5Lဉ6Mင7Oဉ8Pဈ9", new Object[]{"zze", "zzf", "zzg", "zzh", f3.class, "zzi", u3.class, "zzj", "zzk", "zzl", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzm", "zzaf", "zzag", b3.class, "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzav", "zzaw", "zzax", "zzay", e2.f, "zzaz", "zzba", "zzbb", "zzbc", "zzbd", "zzbe", "zzbf", "zzbg", "zzbh", "zzbi", "zzbj", "zzbk", "zzbl", "zzbm", "zzbn", "zzbo", "zzbp", "zzbq"});
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return zzc;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                e6 e6Var = zzd;
                if (e6Var != null) {
                    return e6Var;
                }
                synchronized (n3.class) {
                    try {
                        k5Var = zzd;
                        if (k5Var == null) {
                            k5Var = new k5(6);
                            zzd = k5Var;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return k5Var;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return (byte) 1;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final int h1() {
        return this.zzaq;
    }

    public final boolean j0() {
        return (this.zze & 1048576) != 0;
    }

    public final boolean k0() {
        return (this.zze & 536870912) != 0;
    }

    public final boolean l0() {
        return (this.zzf & 131072) != 0;
    }

    public final boolean m0() {
        return (this.zzf & 128) != 0;
    }

    public final int m1() {
        return this.zzs;
    }

    public final int n() {
        return this.zzbl;
    }

    public final boolean n0() {
        return (this.zzf & 524288) != 0;
    }

    public final f3 o(int i) {
        return (f3) this.zzh.get(i);
    }

    public final boolean o0() {
        return (this.zzf & 8388608) != 0;
    }

    public final boolean p0() {
        return (this.zze & 524288) != 0;
    }

    public final boolean q0() {
        return (this.zze & Integer.MIN_VALUE) != 0;
    }

    public final boolean r0() {
        return (this.zzf & 16) != 0;
    }

    public final int r1() {
        return this.zzi.size();
    }

    public final boolean s0() {
        return (this.zze & 8) != 0;
    }

    public final boolean t0() {
        return (this.zze & 16384) != 0;
    }

    public final boolean u0() {
        return (this.zzf & 262144) != 0;
    }

    public final boolean v0() {
        return (this.zze & 131072) != 0;
    }

    public final boolean w0() {
        return (this.zze & 32) != 0;
    }

    public final long w1() {
        return this.zzam;
    }

    public final boolean x0() {
        return (this.zze & 16) != 0;
    }

    public final boolean y0() {
        return (this.zze & 1) != 0;
    }

    public final boolean z0() {
        return (this.zzf & 2) != 0;
    }
}
