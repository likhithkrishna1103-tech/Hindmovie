package y2;

import aa.c1;
import aa.d0;
import aa.h0;
import aa.j0;
import aa.q;
import e6.j;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import p1.m0;
import p1.p;
import s1.b0;
import s1.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f14512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14513b;

    public f(int i, c1 c1Var) {
        this.f14513b = i;
        this.f14512a = c1Var;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static f c(int i, u uVar) {
        a gVar;
        String str;
        int i10 = 4;
        q.c("initialCapacity", 4);
        Object[] objArrCopyOf = new Object[4];
        int i11 = uVar.f11711c;
        int iB = -2;
        int i12 = 0;
        while (uVar.a() > 8) {
            int iL = uVar.l();
            int iL2 = uVar.f11710b + uVar.l();
            uVar.I(iL2);
            if (iL != 1414744396) {
                d dVar = null;
                switch (iL) {
                    case 1718776947:
                        if (iB != 2) {
                            if (iB == 1) {
                                int iQ = uVar.q();
                                String str2 = iQ != 1 ? iQ != 85 ? iQ != 255 ? iQ != 8192 ? iQ != 8193 ? null : "audio/vnd.dts" : "audio/ac3" : "audio/mp4a-latm" : "audio/mpeg" : "audio/raw";
                                if (str2 != null) {
                                    int iQ2 = uVar.q();
                                    int iL3 = uVar.l();
                                    uVar.K(6);
                                    int iQ3 = uVar.q();
                                    int i13 = b0.f11647a;
                                    int iZ = b0.z(iQ3, ByteOrder.LITTLE_ENDIAN);
                                    int iQ4 = uVar.a() > 0 ? uVar.q() : 0;
                                    p pVar = new p();
                                    pVar.f9967m = m0.p(str2);
                                    pVar.E = iQ2;
                                    pVar.F = iL3;
                                    if (str2.equals("audio/raw") && iZ != 0) {
                                        pVar.G = iZ;
                                    }
                                    if (str2.equals("audio/mp4a-latm") && iQ4 > 0) {
                                        byte[] bArr = new byte[iQ4];
                                        uVar.h(bArr, 0, iQ4);
                                        pVar.f9970p = j0.v(bArr);
                                    }
                                    gVar = new g(new p1.q(pVar));
                                } else {
                                    j.p(iQ, "Ignoring track with unsupported format tag ", "StreamFormatChunk");
                                }
                            } else {
                                s1.b.p("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + b0.E(iB));
                            }
                            gVar = dVar;
                            break;
                        } else {
                            uVar.K(i10);
                            int iL4 = uVar.l();
                            int iL5 = uVar.l();
                            uVar.K(i10);
                            int iL6 = uVar.l();
                            switch (iL6) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str = "video/mp4v-es";
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str = "video/avc";
                                    break;
                                case 842289229:
                                    str = "video/mp42";
                                    break;
                                case 859066445:
                                    str = "video/mp43";
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str = "video/mjpeg";
                                    break;
                                default:
                                    str = null;
                                    break;
                            }
                            if (str != null) {
                                p pVar2 = new p();
                                pVar2.f9974t = iL4;
                                pVar2.f9975u = iL5;
                                pVar2.f9967m = m0.p(str);
                                gVar = new g(new p1.q(pVar2));
                            } else {
                                j.p(iL6, "Ignoring track with unsupported compression ", "StreamFormatChunk");
                                gVar = dVar;
                            }
                        }
                        break;
                    case 1751742049:
                        int iL7 = uVar.l();
                        uVar.K(8);
                        int iL8 = uVar.l();
                        int iL9 = uVar.l();
                        uVar.K(i10);
                        uVar.l();
                        uVar.K(12);
                        gVar = new c(iL7, iL8, iL9);
                        break;
                    case 1752331379:
                        int iL10 = uVar.l();
                        uVar.K(12);
                        uVar.l();
                        int iL11 = uVar.l();
                        int iL12 = uVar.l();
                        uVar.K(i10);
                        int iL13 = uVar.l();
                        int iL14 = uVar.l();
                        uVar.K(i10);
                        dVar = new d(iL10, iL11, iL12, iL13, iL14, uVar.l());
                        gVar = dVar;
                        break;
                    case 1852994675:
                        gVar = new h(uVar.v(uVar.a(), StandardCharsets.UTF_8));
                        break;
                    default:
                        gVar = dVar;
                        break;
                }
            } else {
                gVar = c(uVar.l(), uVar);
            }
            if (gVar != null) {
                if (gVar.a() == 1752331379) {
                    iB = ((d) gVar).b();
                }
                int i14 = i12 + 1;
                int iF = d0.f(objArrCopyOf.length, i14);
                if (iF > objArrCopyOf.length) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, iF);
                }
                objArrCopyOf[i12] = gVar;
                i12 = i14;
            }
            uVar.J(iL2);
            uVar.I(i11);
            i10 = 4;
        }
        return new f(i, j0.l(i12, objArrCopyOf));
    }

    @Override // y2.a
    public final int a() {
        return this.f14513b;
    }

    public final a b(Class cls) {
        h0 h0VarListIterator = this.f14512a.listIterator(0);
        while (h0VarListIterator.hasNext()) {
            a aVar = (a) h0VarListIterator.next();
            if (aVar.getClass() == cls) {
                return aVar;
            }
        }
        return null;
    }
}
