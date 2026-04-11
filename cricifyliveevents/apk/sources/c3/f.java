package c3;

import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import ua.c0;
import ua.g0;
import ua.i0;
import ua.q;
import ua.z0;
import v1.m0;
import v1.o;
import v1.p;
import y1.a0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f2090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2091b;

    public f(int i, z0 z0Var) {
        this.f2091b = i;
        this.f2090a = z0Var;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static f c(int i, t tVar) {
        a gVar;
        String str;
        int i10 = 4;
        q.d(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        int i11 = tVar.f14611c;
        int iB = -2;
        int i12 = 0;
        while (tVar.a() > 8) {
            int iL = tVar.l();
            int iL2 = tVar.f14610b + tVar.l();
            tVar.I(iL2);
            if (iL != 1414744396) {
                d dVar = null;
                switch (iL) {
                    case 1718776947:
                        if (iB != 2) {
                            if (iB == 1) {
                                int iQ = tVar.q();
                                String str2 = iQ != 1 ? iQ != 85 ? iQ != 255 ? iQ != 8192 ? iQ != 8193 ? null : "audio/vnd.dts" : "audio/ac3" : "audio/mp4a-latm" : "audio/mpeg" : "audio/raw";
                                if (str2 != null) {
                                    int iQ2 = tVar.q();
                                    int iL3 = tVar.l();
                                    tVar.K(6);
                                    int iQ3 = tVar.q();
                                    int i13 = a0.f14551a;
                                    int iZ = a0.z(iQ3, ByteOrder.LITTLE_ENDIAN);
                                    int iQ4 = tVar.a() > 0 ? tVar.q() : 0;
                                    o oVar = new o();
                                    oVar.f12893m = m0.p(str2);
                                    oVar.E = iQ2;
                                    oVar.F = iL3;
                                    if (str2.equals("audio/raw") && iZ != 0) {
                                        oVar.G = iZ;
                                    }
                                    if (str2.equals("audio/mp4a-latm") && iQ4 > 0) {
                                        byte[] bArr = new byte[iQ4];
                                        tVar.h(bArr, 0, iQ4);
                                        oVar.f12896p = i0.o(bArr);
                                    }
                                    gVar = new g(new p(oVar));
                                } else {
                                    l0.e.p(iQ, "Ignoring track with unsupported format tag ", "StreamFormatChunk");
                                }
                            } else {
                                y1.b.p("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + a0.E(iB));
                            }
                            gVar = dVar;
                            break;
                        } else {
                            tVar.K(i10);
                            int iL4 = tVar.l();
                            int iL5 = tVar.l();
                            tVar.K(i10);
                            int iL6 = tVar.l();
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
                                o oVar2 = new o();
                                oVar2.f12900t = iL4;
                                oVar2.f12901u = iL5;
                                oVar2.f12893m = m0.p(str);
                                gVar = new g(new p(oVar2));
                            } else {
                                l0.e.p(iL6, "Ignoring track with unsupported compression ", "StreamFormatChunk");
                                gVar = dVar;
                            }
                        }
                        break;
                    case 1751742049:
                        int iL7 = tVar.l();
                        tVar.K(8);
                        int iL8 = tVar.l();
                        int iL9 = tVar.l();
                        tVar.K(i10);
                        tVar.l();
                        tVar.K(12);
                        gVar = new c(iL7, iL8, iL9);
                        break;
                    case 1752331379:
                        int iL10 = tVar.l();
                        tVar.K(12);
                        tVar.l();
                        int iL11 = tVar.l();
                        int iL12 = tVar.l();
                        tVar.K(i10);
                        int iL13 = tVar.l();
                        int iL14 = tVar.l();
                        tVar.K(i10);
                        dVar = new d(iL10, iL11, iL12, iL13, iL14, tVar.l());
                        gVar = dVar;
                        break;
                    case 1852994675:
                        gVar = new h(tVar.v(tVar.a(), StandardCharsets.UTF_8));
                        break;
                    default:
                        gVar = dVar;
                        break;
                }
            } else {
                gVar = c(tVar.l(), tVar);
            }
            if (gVar != null) {
                if (gVar.a() == 1752331379) {
                    iB = ((d) gVar).b();
                }
                int i14 = i12 + 1;
                int iF = c0.f(objArrCopyOf.length, i14);
                if (iF > objArrCopyOf.length) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, iF);
                }
                objArrCopyOf[i12] = gVar;
                i12 = i14;
            }
            tVar.J(iL2);
            tVar.I(i11);
            i10 = 4;
        }
        return new f(i, i0.i(i12, objArrCopyOf));
    }

    @Override // c3.a
    public final int a() {
        return this.f2091b;
    }

    public final a b(Class cls) {
        g0 g0VarListIterator = this.f2090a.listIterator(0);
        while (g0VarListIterator.hasNext()) {
            a aVar = (a) g0VarListIterator.next();
            if (aVar.getClass() == cls) {
                return aVar;
            }
        }
        return null;
    }
}
