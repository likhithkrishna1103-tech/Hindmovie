package q3;

import aa.j0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import p1.k0;
import p1.l0;
import p1.m0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f10699a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static byte[] a(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(1886614376);
        byteBufferAllocate.putInt(uuidArr != null ? 16777216 : 0);
        byteBufferAllocate.putLong(uuid.getMostSignificantBits());
        byteBufferAllocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            byteBufferAllocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                byteBufferAllocate.putLong(uuid2.getMostSignificantBits());
                byteBufferAllocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr == null || bArr.length == 0) {
            byteBufferAllocate.putInt(0);
        } else {
            byteBufferAllocate.putInt(bArr.length);
            byteBufferAllocate.put(bArr);
        }
        return byteBufferAllocate.array();
    }

    public static t1.a b(l0 l0Var, String str) {
        int i = 0;
        while (true) {
            k0[] k0VarArr = l0Var.f9896a;
            if (i >= k0VarArr.length) {
                return null;
            }
            k0 k0Var = k0VarArr[i];
            if (k0Var instanceof t1.a) {
                t1.a aVar = (t1.a) k0Var;
                if (aVar.f11994a.equals(str)) {
                    return aVar;
                }
            }
            i++;
        }
    }

    public static String c(ArrayList arrayList) {
        int size = arrayList.size();
        boolean z2 = false;
        String str = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str2 = ((u) obj).f10730a.f10705g.f10023n;
            if (m0.o(str2)) {
                return "video/mp4";
            }
            if (m0.k(str2)) {
                z2 = true;
            } else if (m0.m(str2)) {
                if (Objects.equals(str2, "image/heic")) {
                    str = "image/heif";
                } else if (Objects.equals(str2, "image/avif")) {
                    str = "image/avif";
                }
            }
        }
        return z2 ? "audio/mp4" : str != null ? str : "application/mp4";
    }

    public static boolean d(int i, boolean z2) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z2) {
            return true;
        }
        for (int i10 = 0; i10 < 29; i10++) {
            if (f10699a[i10] == i) {
                return true;
            }
        }
        return false;
    }

    public static k3.e e(int i, s1.u uVar) {
        int iJ = uVar.j();
        if (uVar.j() == 1684108385) {
            uVar.K(8);
            String strT = uVar.t(iJ - 16);
            return new k3.e("und", strT, strT);
        }
        s1.b.p("MetadataUtil", "Failed to parse comment attribute: " + t1.e.b(i));
        return null;
    }

    public static k3.a f(s1.u uVar) {
        int iJ = uVar.j();
        if (uVar.j() != 1684108385) {
            s1.b.p("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int iJ2 = uVar.j();
        byte[] bArr = f.f10616a;
        int i = iJ2 & 16777215;
        String str = i == 13 ? "image/jpeg" : i == 14 ? "image/png" : null;
        if (str == null) {
            e6.j.p(i, "Unrecognized cover art flags: ", "MetadataUtil");
            return null;
        }
        uVar.K(4);
        int i10 = iJ - 16;
        byte[] bArr2 = new byte[i10];
        uVar.h(bArr2, 0, i10);
        return new k3.a(str, null, 3, bArr2);
    }

    public static k3.n g(int i, String str, s1.u uVar) {
        int iJ = uVar.j();
        if (uVar.j() == 1684108385 && iJ >= 22) {
            uVar.K(10);
            int iD = uVar.D();
            if (iD > 0) {
                String strL = e6.j.l("", iD);
                int iD2 = uVar.D();
                if (iD2 > 0) {
                    strL = strL + "/" + iD2;
                }
                return new k3.n(str, null, j0.v(strL));
            }
        }
        s1.b.p("MetadataUtil", "Failed to parse index/count attribute: " + t1.e.b(i));
        return null;
    }

    public static int h(s1.u uVar) {
        int iJ = uVar.j();
        if (uVar.j() == 1684108385) {
            uVar.K(8);
            int i = iJ - 16;
            if (i == 1) {
                return uVar.x();
            }
            if (i == 2) {
                return uVar.D();
            }
            if (i == 3) {
                return uVar.A();
            }
            if (i == 4 && (uVar.f11709a[uVar.f11710b] & 128) == 0) {
                return uVar.B();
            }
        }
        s1.b.p("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    public static k3.i i(int i, String str, s1.u uVar, boolean z2, boolean z10) {
        int iH = h(uVar);
        if (z10) {
            iH = Math.min(1, iH);
        }
        if (iH >= 0) {
            return z2 ? new k3.n(str, null, j0.v(Integer.toString(iH))) : new k3.e("und", str, Integer.toString(iH));
        }
        s1.b.p("MetadataUtil", "Failed to parse uint8 attribute: " + t1.e.b(i));
        return null;
    }

    public static p7.m j(byte[] bArr) {
        UUID[] uuidArr;
        s1.u uVar = new s1.u(bArr);
        if (uVar.f11711c < 32) {
            return null;
        }
        uVar.J(0);
        int iA = uVar.a();
        int iJ = uVar.j();
        if (iJ != iA) {
            s1.b.p("PsshAtomUtil", "Advertised atom size (" + iJ + ") does not match buffer size: " + iA);
            return null;
        }
        int iJ2 = uVar.j();
        if (iJ2 != 1886614376) {
            e6.j.p(iJ2, "Atom type is not pssh: ", "PsshAtomUtil");
            return null;
        }
        int iE = f.e(uVar.j());
        if (iE > 1) {
            e6.j.p(iE, "Unsupported pssh version: ", "PsshAtomUtil");
            return null;
        }
        UUID uuid = new UUID(uVar.r(), uVar.r());
        if (iE == 1) {
            int iB = uVar.B();
            uuidArr = new UUID[iB];
            for (int i = 0; i < iB; i++) {
                uuidArr[i] = new UUID(uVar.r(), uVar.r());
            }
        } else {
            uuidArr = null;
        }
        int iB2 = uVar.B();
        int iA2 = uVar.a();
        if (iB2 != iA2) {
            s1.b.p("PsshAtomUtil", "Atom data size (" + iB2 + ") does not match the bytes left: " + iA2);
            return null;
        }
        byte[] bArr2 = new byte[iB2];
        uVar.h(bArr2, 0, iB2);
        p7.m mVar = new p7.m();
        mVar.f10284v = uuid;
        mVar.f10283u = iE;
        mVar.f10285w = bArr2;
        mVar.f10286x = uuidArr;
        return mVar;
    }

    public static byte[] k(UUID uuid, byte[] bArr) {
        p7.m mVarJ = j(bArr);
        if (mVarJ == null) {
            return null;
        }
        UUID uuid2 = (UUID) mVarJ.f10284v;
        if (uuid.equals(uuid2)) {
            return (byte[]) mVarJ.f10285w;
        }
        s1.b.p("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + uuid2 + ".");
        return null;
    }

    public static k3.n l(int i, String str, s1.u uVar) {
        int iJ = uVar.j();
        if (uVar.j() == 1684108385) {
            uVar.K(8);
            return new k3.n(str, null, j0.v(uVar.t(iJ - 16)));
        }
        s1.b.p("MetadataUtil", "Failed to parse text attribute: " + t1.e.b(i));
        return null;
    }

    public static void m(int i, l0 l0Var, p1.p pVar, l0 l0Var2, l0... l0VarArr) {
        if (l0Var2 == null) {
            l0Var2 = new l0(new k0[0]);
        }
        if (l0Var != null) {
            int i10 = 0;
            while (true) {
                k0[] k0VarArr = l0Var.f9896a;
                if (i10 >= k0VarArr.length) {
                    break;
                }
                k0 k0Var = k0VarArr[i10];
                if (k0Var instanceof t1.a) {
                    t1.a aVar = (t1.a) k0Var;
                    if (!aVar.f11994a.equals("com.android.capture.fps")) {
                        l0Var2 = l0Var2.a(aVar);
                    } else if (i == 2) {
                        l0Var2 = l0Var2.a(aVar);
                    }
                }
                i10++;
            }
        }
        for (l0 l0Var3 : l0VarArr) {
            l0Var2 = l0Var2.b(l0Var3);
        }
        if (l0Var2.f9896a.length > 0) {
            pVar.f9965k = l0Var2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static w2.f0 n(w2.p r25, boolean r26, boolean r27) {
        /*
            Method dump skipped, instruction units count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.q.n(w2.p, boolean, boolean):w2.f0");
    }
}
