package q3;

import android.util.Pair;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import k8.o3;
import p1.l0;
import p1.m0;
import p1.n0;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f10616a;

    static {
        int i = b0.f11647a;
        f10616a = "OpusHead".getBytes(StandardCharsets.UTF_8);
    }

    public static void a(s1.u uVar) {
        int i = uVar.f11710b;
        uVar.K(4);
        if (uVar.j() != 1751411826) {
            i += 4;
        }
        uVar.J(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0673  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0675  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x06e0  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x06ea  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x0794  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x07db  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x09e4 A[LOOP:18: B:495:0x09e4->B:633:?, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:503:0x0a21  */
    /* JADX WARN: Removed duplicated region for block: B:598:0x0834 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:627:? A[LOOP:15: B:483:0x09ab->B:627:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:629:? A[LOOP:16: B:487:0x09c5->B:629:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:631:? A[LOOP:17: B:490:0x09cd->B:631:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(s1.u r50, int r51, int r52, int r53, int r54, java.lang.String r55, boolean r56, p1.m r57, q3.d r58, int r59) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 3252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.f.b(s1.u, int, int, int, int, java.lang.String, boolean, p1.m, q3.d, int):void");
    }

    public static o3 c(int i, s1.u uVar) {
        uVar.J(i + 12);
        uVar.K(1);
        d(uVar);
        uVar.K(2);
        int iX = uVar.x();
        if ((iX & 128) != 0) {
            uVar.K(2);
        }
        if ((iX & 64) != 0) {
            uVar.K(uVar.x());
        }
        if ((iX & 32) != 0) {
            uVar.K(2);
        }
        uVar.K(1);
        d(uVar);
        String strF = m0.f(uVar.x());
        if ("audio/mpeg".equals(strF) || "audio/vnd.dts".equals(strF) || "audio/vnd.dts.hd".equals(strF)) {
            return new o3(strF, null, -1L, -1L);
        }
        uVar.K(4);
        long jZ = uVar.z();
        long jZ2 = uVar.z();
        uVar.K(1);
        int iD = d(uVar);
        long j5 = jZ2;
        byte[] bArr = new byte[iD];
        uVar.h(bArr, 0, iD);
        if (j5 <= 0) {
            j5 = -1;
        }
        return new o3(strF, bArr, j5, jZ > 0 ? jZ : -1L);
    }

    public static int d(s1.u uVar) {
        int iX = uVar.x();
        int i = iX & ModuleDescriptor.MODULE_VERSION;
        while ((iX & 128) == 128) {
            iX = uVar.x();
            i = (i << 7) | (iX & ModuleDescriptor.MODULE_VERSION);
        }
        return i;
    }

    public static int e(int i) {
        return (i >> 24) & 255;
    }

    public static l0 f(t1.c cVar) {
        t1.a aVar;
        t1.d dVarN = cVar.n(1751411826);
        t1.d dVarN2 = cVar.n(1801812339);
        t1.d dVarN3 = cVar.n(1768715124);
        if (dVarN != null && dVarN2 != null && dVarN3 != null) {
            s1.u uVar = dVarN.f12002c;
            uVar.J(16);
            if (uVar.j() == 1835299937) {
                s1.u uVar2 = dVarN2.f12002c;
                uVar2.J(12);
                int iJ = uVar2.j();
                String[] strArr = new String[iJ];
                for (int i = 0; i < iJ; i++) {
                    int iJ2 = uVar2.j();
                    uVar2.K(4);
                    strArr[i] = uVar2.v(iJ2 - 8, StandardCharsets.UTF_8);
                }
                s1.u uVar3 = dVarN3.f12002c;
                uVar3.J(8);
                ArrayList arrayList = new ArrayList();
                while (uVar3.a() > 8) {
                    int i10 = uVar3.f11710b;
                    int iJ3 = uVar3.j();
                    int iJ4 = uVar3.j() - 1;
                    if (iJ4 < 0 || iJ4 >= iJ) {
                        e6.j.p(iJ4, "Skipped metadata with unknown key index: ", "BoxParsers");
                    } else {
                        String str = strArr[iJ4];
                        int i11 = i10 + iJ3;
                        while (true) {
                            int i12 = uVar3.f11710b;
                            if (i12 >= i11) {
                                aVar = null;
                                break;
                            }
                            int iJ5 = uVar3.j();
                            if (uVar3.j() == 1684108385) {
                                int iJ6 = uVar3.j();
                                int iJ7 = uVar3.j();
                                int i13 = iJ5 - 16;
                                byte[] bArr = new byte[i13];
                                uVar3.h(bArr, 0, i13);
                                aVar = new t1.a(str, bArr, iJ7, iJ6);
                                break;
                            }
                            uVar3.J(i12 + iJ5);
                        }
                        if (aVar != null) {
                            arrayList.add(aVar);
                        }
                    }
                    uVar3.J(i10 + iJ3);
                }
                if (!arrayList.isEmpty()) {
                    return new l0(arrayList);
                }
            }
        }
        return null;
    }

    public static t1.g g(s1.u uVar) {
        long jR;
        long jR2;
        uVar.J(8);
        if (e(uVar.j()) == 0) {
            jR = uVar.z();
            jR2 = uVar.z();
        } else {
            jR = uVar.r();
            jR2 = uVar.r();
        }
        return new t1.g(jR, jR2, uVar.z());
    }

    public static Pair h(s1.u uVar, int i, int i10) throws n0 {
        Integer num;
        s sVar;
        Pair pairCreate;
        int i11;
        int i12;
        Integer num2;
        boolean z2;
        int i13 = uVar.f11710b;
        while (i13 - i < i10) {
            uVar.J(i13);
            int iJ = uVar.j();
            w2.b.d("childAtomSize must be positive", iJ > 0);
            if (uVar.j() == 1936289382) {
                int i14 = i13 + 8;
                int i15 = 0;
                int i16 = -1;
                Integer numValueOf = null;
                String strV = null;
                while (i14 - i13 < iJ) {
                    uVar.J(i14);
                    int iJ2 = uVar.j();
                    int iJ3 = uVar.j();
                    if (iJ3 == 1718775137) {
                        numValueOf = Integer.valueOf(uVar.j());
                    } else if (iJ3 == 1935894637) {
                        uVar.K(4);
                        strV = uVar.v(4, StandardCharsets.UTF_8);
                    } else if (iJ3 == 1935894633) {
                        i16 = i14;
                        i15 = iJ2;
                    }
                    i14 += iJ2;
                }
                byte[] bArr = null;
                if ("cenc".equals(strV) || "cbc1".equals(strV) || "cens".equals(strV) || "cbcs".equals(strV)) {
                    w2.b.d("frma atom is mandatory", numValueOf != null);
                    w2.b.d("schi atom is mandatory", i16 != -1);
                    int i17 = i16 + 8;
                    while (true) {
                        if (i17 - i16 >= i15) {
                            num = numValueOf;
                            sVar = null;
                            break;
                        }
                        uVar.J(i17);
                        int iJ4 = uVar.j();
                        if (uVar.j() == 1952804451) {
                            int iE = e(uVar.j());
                            uVar.K(1);
                            if (iE == 0) {
                                uVar.K(1);
                                i12 = 0;
                                i11 = 0;
                            } else {
                                int iX = uVar.x();
                                i11 = iX & 15;
                                i12 = (iX & 240) >> 4;
                            }
                            if (uVar.x() == 1) {
                                num2 = numValueOf;
                                z2 = true;
                            } else {
                                num2 = numValueOf;
                                z2 = false;
                            }
                            int iX2 = uVar.x();
                            byte[] bArr2 = new byte[16];
                            uVar.h(bArr2, 0, 16);
                            if (z2 && iX2 == 0) {
                                int iX3 = uVar.x();
                                byte[] bArr3 = new byte[iX3];
                                uVar.h(bArr3, 0, iX3);
                                bArr = bArr3;
                            }
                            num = num2;
                            sVar = new s(z2, strV, iX2, bArr2, i12, i11, bArr);
                        } else {
                            i17 += iJ4;
                        }
                    }
                    w2.b.d("tenc atom is mandatory", sVar != null);
                    int i18 = b0.f11647a;
                    pairCreate = Pair.create(num, sVar);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            i13 += iJ;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x07fb  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x081b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static q3.d i(s1.u r66, q3.e r67, java.lang.String r68, p1.m r69, boolean r70) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 3446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.f.i(s1.u, q3.e, java.lang.String, p1.m, boolean):q3.d");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e5, code lost:
    
        r23 = -9223372036854775807L;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x06db  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x06de  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0803  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x080c  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x084b A[PHI: r15
      0x084b: PHI (r15v19 int) = (r15v18 int), (r15v32 int) binds: [B:329:0x080a, B:337:0x084a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:339:0x084d  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x084f  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0867  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x090c  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x090e  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0914  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0917  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x091a  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x091d  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0921  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0924  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0928  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x092b  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0939  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x09bb  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x09ce  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x09f3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:462:0x0201 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList j(t1.c r54, w2.w r55, long r56, p1.m r58, boolean r59, boolean r60, z9.f r61) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 2557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.f.j(t1.c, w2.w, long, p1.m, boolean, boolean, z9.f):java.util.ArrayList");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01ba, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01bb, code lost:
    
        r1.J(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01c0, code lost:
    
        r16 = r3 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01c5, code lost:
    
        r0 = 16777215 & r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01cc, code lost:
    
        if (r0 != 6516084) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01ce, code lost:
    
        r9 = q3.q.e(r13, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01d6, code lost:
    
        if (r0 == 7233901) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01db, code lost:
    
        if (r0 != 7631467) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01e2, code lost:
    
        if (r0 == 6516589) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01e7, code lost:
    
        if (r0 != 7828084) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01ee, code lost:
    
        if (r0 != 6578553) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01f0, code lost:
    
        r9 = q3.q.l(r13, "TDRC", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01fa, code lost:
    
        if (r0 != 4280916) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01fc, code lost:
    
        r9 = q3.q.l(r13, "TPE1", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0206, code lost:
    
        if (r0 != 7630703) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0208, code lost:
    
        r9 = q3.q.l(r13, "TSSE", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0212, code lost:
    
        if (r0 != 6384738) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0214, code lost:
    
        r9 = q3.q.l(r13, "TALB", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x021e, code lost:
    
        if (r0 != 7108978) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
    
        r1.J(r7);
        r7 = r7 + r13;
        r1.K(r0);
        r6 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0220, code lost:
    
        r9 = q3.q.l(r13, "USLT", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x022a, code lost:
    
        if (r0 != 6776174) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x022c, code lost:
    
        r9 = q3.q.l(r13, "TCON", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0234, code lost:
    
        if (r0 != 6779504) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0236, code lost:
    
        r9 = q3.q.l(r13, "TIT1", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x023e, code lost:
    
        s1.b.f("MetadataUtil", "Skipped unknown metadata entry: " + t1.e.b(r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0251, code lost:
    
        r1.J(r15);
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0256, code lost:
    
        r9 = q3.q.l(r13, "TCOM", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0050, code lost:
    
        r13 = r1.f11710b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x025e, code lost:
    
        r9 = q3.q.l(r13, "TIT2", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0266, code lost:
    
        if (r9 == null) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0268, code lost:
    
        r6.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x026b, code lost:
    
        r3 = r16;
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0272, code lost:
    
        r1.J(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0275, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0276, code lost:
    
        r16 = r3 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x027c, code lost:
    
        if (r6.isEmpty() == false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x027e, code lost:
    
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:
    
        if (r13 >= r7) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0280, code lost:
    
        r12 = new p1.l0(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
    
        r15 = r1.j() + r13;
        r13 = r1.j();
        r0 = (r13 >> 24) & 255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0069, code lost:
    
        if (r0 == 169) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006d, code lost:
    
        if (r0 != 253) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        r16 = r3 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
    
        if (r13 != 1735291493) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
    
        r0 = k3.j.a(q3.q.h(r1) - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:
    
        if (r0 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
    
        r9 = new k3.n("TCON", r12, aa.j0.v(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008e, code lost:
    
        s1.b.p("MetadataUtil", "Failed to parse standard genre code");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0093, code lost:
    
        r9 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0094, code lost:
    
        r1.J(r15);
        r16 = r3 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009f, code lost:
    
        if (r13 != 1684632427) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a1, code lost:
    
        r9 = q3.q.g(r13, "TPOS", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ae, code lost:
    
        if (r13 != 1953655662) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b0, code lost:
    
        r9 = q3.q.g(r13, "TRCK", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ba, code lost:
    
        if (r13 != 1953329263) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bc, code lost:
    
        r9 = q3.q.i(r13, "TBPM", r1, true, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c6, code lost:
    
        if (r13 != 1668311404) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c8, code lost:
    
        r9 = q3.q.i(r13, "TCMP", r1, true, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d2, code lost:
    
        if (r13 != 1668249202) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d4, code lost:
    
        r9 = q3.q.f(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00dc, code lost:
    
        if (r13 != 1631670868) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00de, code lost:
    
        r9 = q3.q.l(r13, "TPE2", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e8, code lost:
    
        if (r13 != 1936682605) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ea, code lost:
    
        r9 = q3.q.l(r13, "TSOT", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f4, code lost:
    
        if (r13 != 1936679276) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f6, code lost:
    
        r9 = q3.q.l(r13, "TSOA", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0100, code lost:
    
        if (r13 != 1936679282) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0102, code lost:
    
        r9 = q3.q.l(r13, "TSOP", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x010c, code lost:
    
        if (r13 != 1936679265) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x010e, code lost:
    
        r9 = q3.q.l(r13, "TSO2", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0119, code lost:
    
        if (r13 != 1936679791) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x011b, code lost:
    
        r9 = q3.q.l(r13, "TSOC", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0126, code lost:
    
        if (r13 != 1920233063) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0128, code lost:
    
        r9 = q3.q.i(r13, "ITUNESADVISORY", r1, r3, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0133, code lost:
    
        if (r13 != 1885823344) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0135, code lost:
    
        r9 = q3.q.i(r13, "ITUNESGAPLESS", r1, r3, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0140, code lost:
    
        if (r13 != 1936683886) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0142, code lost:
    
        r9 = q3.q.l(r13, "TVSHOWSORT", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x014d, code lost:
    
        if (r13 != 1953919848) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x014f, code lost:
    
        r9 = q3.q.l(r13, "TVSHOW", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x015a, code lost:
    
        if (r13 != 757935405) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x015c, code lost:
    
        r0 = r12;
        r8 = r0;
        r9 = -1;
        r10 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0160, code lost:
    
        r13 = r1.f11710b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0162, code lost:
    
        if (r13 >= r15) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0164, code lost:
    
        r14 = r1.j();
        r12 = r1.j();
        r16 = r3;
        r1.K(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0175, code lost:
    
        if (r12 != 1835360622) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0177, code lost:
    
        r0 = r1.t(r14 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0181, code lost:
    
        if (r12 != 1851878757) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0183, code lost:
    
        r8 = r1.t(r14 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x018d, code lost:
    
        if (r12 != 1684108385) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x018f, code lost:
    
        r9 = r13;
        r10 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0191, code lost:
    
        r1.K(r14 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0196, code lost:
    
        r3 = r16 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x019a, code lost:
    
        r16 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x019c, code lost:
    
        if (r0 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x019e, code lost:
    
        if (r8 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01a1, code lost:
    
        if (r9 != (-1)) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01a4, code lost:
    
        r1.J(r9);
        r1.K(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01b7, code lost:
    
        r9 = new k3.k(r0, r8, r1.t(r10 - 16));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0328  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static p1.l0 k(t1.d r17) {
        /*
            Method dump skipped, instruction units count: 942
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.f.k(t1.d):p1.l0");
    }
}
