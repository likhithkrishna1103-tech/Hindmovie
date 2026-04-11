package u3;

import android.text.SpannableStringBuilder;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import o8.j;
import s1.t;
import s1.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u f12745h = new u();
    public final t i = new t();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12746j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f12747k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e[] f12748l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e f12749m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f12750n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List f12751o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public t f12752p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12753q;

    public f(int i, List list) {
        this.f12747k = i == -1 ? 1 : i;
        if (list != null) {
            byte[] bArr = s1.e.f11662a;
            if (list.size() == 1 && ((byte[]) list.get(0)).length == 1) {
                byte b10 = ((byte[]) list.get(0))[0];
            }
        }
        this.f12748l = new e[8];
        for (int i10 = 0; i10 < 8; i10++) {
            this.f12748l[i10] = new e();
        }
        this.f12749m = this.f12748l[0];
    }

    @Override // u3.i
    public final j b() {
        List list = this.f12750n;
        this.f12751o = list;
        list.getClass();
        return new j(1, list);
    }

    @Override // u3.i
    public final void c(g gVar) {
        ByteBuffer byteBuffer = gVar.data;
        byteBuffer.getClass();
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        u uVar = this.f12745h;
        uVar.H(iLimit, bArrArray);
        while (uVar.a() >= 3) {
            int iX = uVar.x();
            int i = iX & 3;
            boolean z2 = (iX & 4) == 4;
            byte bX = (byte) uVar.x();
            byte bX2 = (byte) uVar.x();
            if (i == 2 || i == 3) {
                if (z2) {
                    if (i == 3) {
                        f();
                        int i10 = (bX & 192) >> 6;
                        int i11 = this.f12746j;
                        if (i11 != -1 && i10 != (i11 + 1) % 4) {
                            h();
                            s1.b.p("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f12746j + " current=" + i10);
                        }
                        this.f12746j = i10;
                        int i12 = bX & 63;
                        if (i12 == 0) {
                            i12 = 64;
                        }
                        t tVar = new t(i10, i12);
                        this.f12752p = tVar;
                        byte[] bArr = tVar.f11703b;
                        tVar.f11706e = 1;
                        bArr[0] = bX2;
                    } else {
                        s1.d.b(i == 2);
                        t tVar2 = this.f12752p;
                        if (tVar2 == null) {
                            s1.b.g("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = tVar2.f11703b;
                            int i13 = tVar2.f11706e;
                            int i14 = i13 + 1;
                            tVar2.f11706e = i14;
                            bArr2[i13] = bX;
                            tVar2.f11706e = i13 + 2;
                            bArr2[i14] = bX2;
                        }
                    }
                    t tVar3 = this.f12752p;
                    if (tVar3.f11706e == (tVar3.f11705d * 2) - 1) {
                        f();
                    }
                }
            }
        }
    }

    @Override // u3.i
    public final boolean e() {
        return this.f12750n != this.f12751o;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void f() {
        char c9;
        int i;
        boolean z2;
        t tVar = this.f12752p;
        if (tVar == null) {
            return;
        }
        int i10 = 2;
        if (tVar.f11706e != (tVar.f11705d * 2) - 1) {
            s1.b.f("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f12752p.f11705d * 2) - 1) + ", but current index is " + this.f12752p.f11706e + " (sequence number " + this.f12752p.f11704c + ");");
        }
        t tVar2 = this.f12752p;
        byte[] bArr = tVar2.f11703b;
        int i11 = tVar2.f11706e;
        t tVar3 = this.i;
        tVar3.o(i11, bArr);
        boolean z10 = false;
        while (true) {
            if (tVar3.b() > 0) {
                int i12 = 3;
                int i13 = tVar3.i(3);
                int i14 = tVar3.i(5);
                if (i13 == 7) {
                    tVar3.t(i10);
                    i13 = tVar3.i(6);
                    if (i13 < 7) {
                        e6.j.p(i13, "Invalid extended service number: ", "Cea708Decoder");
                    }
                }
                if (i14 == 0) {
                    if (i13 != 0) {
                        s1.b.p("Cea708Decoder", "serviceNumber is non-zero (" + i13 + ") when blockSize is 0");
                    }
                } else if (i13 != this.f12747k) {
                    tVar3.u(i14);
                } else {
                    int iG = (i14 * 8) + tVar3.g();
                    while (tVar3.g() < iG) {
                        int i15 = tVar3.i(8);
                        if (i15 != 16) {
                            if (i15 <= 31) {
                                if (i15 != 0) {
                                    if (i15 == i12) {
                                        this.f12750n = g();
                                    } else if (i15 != 8) {
                                        switch (i15) {
                                            case 12:
                                                h();
                                                break;
                                            case 13:
                                                this.f12749m.a('\n');
                                                break;
                                            case 14:
                                                break;
                                            default:
                                                if (i15 >= 17 && i15 <= 23) {
                                                    s1.b.p("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i15);
                                                    tVar3.t(8);
                                                } else if (i15 < 24 || i15 > 31) {
                                                    e6.j.p(i15, "Invalid C0 command: ", "Cea708Decoder");
                                                } else {
                                                    s1.b.p("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i15);
                                                    tVar3.t(16);
                                                }
                                                break;
                                        }
                                    } else {
                                        SpannableStringBuilder spannableStringBuilder = this.f12749m.f12727b;
                                        int length = spannableStringBuilder.length();
                                        if (length > 0) {
                                            spannableStringBuilder.delete(length - 1, length);
                                        }
                                    }
                                }
                                i = i10;
                            } else if (i15 <= 127) {
                                if (i15 == 127) {
                                    this.f12749m.a((char) 9835);
                                } else {
                                    this.f12749m.a((char) (i15 & 255));
                                }
                                i = i10;
                                z10 = true;
                            } else {
                                if (i15 <= 159) {
                                    e[] eVarArr = this.f12748l;
                                    switch (i15) {
                                        case 128:
                                        case 129:
                                        case 130:
                                        case 131:
                                        case 132:
                                        case 133:
                                        case 134:
                                        case 135:
                                            z2 = true;
                                            int i16 = i15 - 128;
                                            if (this.f12753q != i16) {
                                                this.f12753q = i16;
                                                this.f12749m = eVarArr[i16];
                                            }
                                            break;
                                        case 136:
                                            z2 = true;
                                            for (int i17 = 1; i17 <= 8; i17++) {
                                                if (tVar3.h()) {
                                                    e eVar = eVarArr[8 - i17];
                                                    eVar.f12726a.clear();
                                                    eVar.f12727b.clear();
                                                    eVar.f12738o = -1;
                                                    eVar.f12739p = -1;
                                                    eVar.f12740q = -1;
                                                    eVar.f12742s = -1;
                                                    eVar.f12744u = 0;
                                                }
                                            }
                                            break;
                                        case 137:
                                            for (int i18 = 1; i18 <= 8; i18++) {
                                                if (tVar3.h()) {
                                                    eVarArr[8 - i18].f12729d = true;
                                                }
                                            }
                                            z2 = true;
                                            break;
                                        case 138:
                                            for (int i19 = 1; i19 <= 8; i19++) {
                                                if (tVar3.h()) {
                                                    eVarArr[8 - i19].f12729d = false;
                                                }
                                            }
                                            z2 = true;
                                            break;
                                        case 139:
                                            for (int i20 = 1; i20 <= 8; i20++) {
                                                if (tVar3.h()) {
                                                    eVarArr[8 - i20].f12729d = !r1.f12729d;
                                                }
                                            }
                                            z2 = true;
                                            break;
                                        case 140:
                                            for (int i21 = 1; i21 <= 8; i21++) {
                                                if (tVar3.h()) {
                                                    eVarArr[8 - i21].d();
                                                }
                                            }
                                            z2 = true;
                                            break;
                                        case 141:
                                            tVar3.t(8);
                                            z2 = true;
                                            break;
                                        case 142:
                                            z2 = true;
                                            break;
                                        case 143:
                                            h();
                                            z2 = true;
                                            break;
                                        case 144:
                                            int i22 = i10;
                                            if (this.f12749m.f12728c) {
                                                tVar3.i(4);
                                                tVar3.i(i22);
                                                tVar3.i(i22);
                                                boolean zH = tVar3.h();
                                                boolean zH2 = tVar3.h();
                                                i12 = 3;
                                                tVar3.i(3);
                                                tVar3.i(3);
                                                this.f12749m.e(zH, zH2);
                                                z2 = true;
                                            } else {
                                                tVar3.t(16);
                                                z2 = true;
                                                i12 = 3;
                                            }
                                            break;
                                        case 145:
                                            if (this.f12749m.f12728c) {
                                                int iC = e.c(tVar3.i(2), tVar3.i(2), tVar3.i(2), tVar3.i(2));
                                                int iC2 = e.c(tVar3.i(2), tVar3.i(2), tVar3.i(2), tVar3.i(2));
                                                tVar3.t(2);
                                                e.c(tVar3.i(2), tVar3.i(2), tVar3.i(2), 0);
                                                this.f12749m.f(iC, iC2);
                                            } else {
                                                tVar3.t(24);
                                            }
                                            z2 = true;
                                            i12 = 3;
                                            break;
                                        case 146:
                                            if (this.f12749m.f12728c) {
                                                tVar3.t(4);
                                                int i23 = tVar3.i(4);
                                                tVar3.t(2);
                                                tVar3.i(6);
                                                e eVar2 = this.f12749m;
                                                if (eVar2.f12744u != i23) {
                                                    eVar2.a('\n');
                                                }
                                                eVar2.f12744u = i23;
                                            } else {
                                                tVar3.t(16);
                                            }
                                            z2 = true;
                                            i12 = 3;
                                            break;
                                        case 147:
                                        case 148:
                                        case 149:
                                        case 150:
                                        default:
                                            e6.j.p(i15, "Invalid C1 command: ", "Cea708Decoder");
                                            z2 = true;
                                            break;
                                        case 151:
                                            if (this.f12749m.f12728c) {
                                                int iC3 = e.c(tVar3.i(2), tVar3.i(2), tVar3.i(2), tVar3.i(2));
                                                tVar3.i(2);
                                                e.c(tVar3.i(2), tVar3.i(2), tVar3.i(2), 0);
                                                tVar3.h();
                                                tVar3.h();
                                                tVar3.i(2);
                                                tVar3.i(2);
                                                int i24 = tVar3.i(2);
                                                tVar3.t(8);
                                                e eVar3 = this.f12749m;
                                                eVar3.f12737n = iC3;
                                                eVar3.f12734k = i24;
                                            } else {
                                                tVar3.t(32);
                                            }
                                            z2 = true;
                                            i12 = 3;
                                            break;
                                        case 152:
                                        case 153:
                                        case 154:
                                        case 155:
                                        case 156:
                                        case 157:
                                        case 158:
                                        case 159:
                                            int i25 = i15 - 152;
                                            e eVar4 = eVarArr[i25];
                                            tVar3.t(i10);
                                            boolean zH3 = tVar3.h();
                                            tVar3.t(i10);
                                            int i26 = tVar3.i(i12);
                                            boolean zH4 = tVar3.h();
                                            int i27 = tVar3.i(7);
                                            int i28 = tVar3.i(8);
                                            int i29 = tVar3.i(4);
                                            int i30 = tVar3.i(4);
                                            tVar3.t(i10);
                                            tVar3.t(6);
                                            tVar3.t(i10);
                                            int i31 = tVar3.i(3);
                                            int i32 = tVar3.i(3);
                                            ArrayList arrayList = eVar4.f12726a;
                                            eVar4.f12728c = true;
                                            eVar4.f12729d = zH3;
                                            eVar4.f12730e = i26;
                                            eVar4.f = zH4;
                                            eVar4.f12731g = i27;
                                            eVar4.f12732h = i28;
                                            eVar4.i = i29;
                                            int i33 = i30 + 1;
                                            if (eVar4.f12733j != i33) {
                                                eVar4.f12733j = i33;
                                                while (true) {
                                                    if (arrayList.size() >= eVar4.f12733j || arrayList.size() >= 15) {
                                                        arrayList.remove(0);
                                                    }
                                                }
                                            }
                                            if (i31 != 0 && eVar4.f12735l != i31) {
                                                eVar4.f12735l = i31;
                                                int i34 = i31 - 1;
                                                int i35 = e.B[i34];
                                                boolean z11 = e.A[i34];
                                                int i36 = e.f12724y[i34];
                                                int i37 = e.f12725z[i34];
                                                int i38 = e.f12723x[i34];
                                                eVar4.f12737n = i35;
                                                eVar4.f12734k = i38;
                                            }
                                            if (i32 != 0 && eVar4.f12736m != i32) {
                                                eVar4.f12736m = i32;
                                                int i39 = i32 - 1;
                                                int i40 = e.D[i39];
                                                int i41 = e.C[i39];
                                                eVar4.e(false, false);
                                                eVar4.f(e.f12721v, e.E[i39]);
                                            }
                                            if (this.f12753q != i25) {
                                                this.f12753q = i25;
                                                this.f12749m = eVarArr[i25];
                                            }
                                            z2 = true;
                                            i12 = 3;
                                            break;
                                    }
                                } else {
                                    z2 = true;
                                    if (i15 <= 255) {
                                        this.f12749m.a((char) (i15 & 255));
                                    } else {
                                        e6.j.p(i15, "Invalid base command: ", "Cea708Decoder");
                                        i = 2;
                                        c9 = 7;
                                    }
                                }
                                z10 = z2;
                                i = 2;
                                c9 = 7;
                            }
                            c9 = 7;
                        } else {
                            int i42 = tVar3.i(8);
                            if (i42 <= 31) {
                                c9 = 7;
                                if (i42 > 7) {
                                    if (i42 <= 15) {
                                        tVar3.t(8);
                                    } else if (i42 <= 23) {
                                        tVar3.t(16);
                                    } else if (i42 <= 31) {
                                        tVar3.t(24);
                                    }
                                }
                            } else {
                                c9 = 7;
                                if (i42 <= 127) {
                                    if (i42 == 32) {
                                        this.f12749m.a(' ');
                                    } else if (i42 == 33) {
                                        this.f12749m.a((char) 160);
                                    } else if (i42 == 37) {
                                        this.f12749m.a((char) 8230);
                                    } else if (i42 == 42) {
                                        this.f12749m.a((char) 352);
                                    } else if (i42 == 44) {
                                        this.f12749m.a((char) 338);
                                    } else if (i42 == 63) {
                                        this.f12749m.a((char) 376);
                                    } else if (i42 == 57) {
                                        this.f12749m.a((char) 8482);
                                    } else if (i42 == 58) {
                                        this.f12749m.a((char) 353);
                                    } else if (i42 == 60) {
                                        this.f12749m.a((char) 339);
                                    } else if (i42 != 61) {
                                        switch (i42) {
                                            case 48:
                                                this.f12749m.a((char) 9608);
                                                break;
                                            case 49:
                                                this.f12749m.a((char) 8216);
                                                break;
                                            case 50:
                                                this.f12749m.a((char) 8217);
                                                break;
                                            case 51:
                                                this.f12749m.a((char) 8220);
                                                break;
                                            case 52:
                                                this.f12749m.a((char) 8221);
                                                break;
                                            case 53:
                                                this.f12749m.a((char) 8226);
                                                break;
                                            default:
                                                switch (i42) {
                                                    case 118:
                                                        this.f12749m.a((char) 8539);
                                                        break;
                                                    case 119:
                                                        this.f12749m.a((char) 8540);
                                                        break;
                                                    case 120:
                                                        this.f12749m.a((char) 8541);
                                                        break;
                                                    case 121:
                                                        this.f12749m.a((char) 8542);
                                                        break;
                                                    case 122:
                                                        this.f12749m.a((char) 9474);
                                                        break;
                                                    case 123:
                                                        this.f12749m.a((char) 9488);
                                                        break;
                                                    case 124:
                                                        this.f12749m.a((char) 9492);
                                                        break;
                                                    case 125:
                                                        this.f12749m.a((char) 9472);
                                                        break;
                                                    case 126:
                                                        this.f12749m.a((char) 9496);
                                                        break;
                                                    case ModuleDescriptor.MODULE_VERSION /* 127 */:
                                                        this.f12749m.a((char) 9484);
                                                        break;
                                                    default:
                                                        e6.j.p(i42, "Invalid G2 character: ", "Cea708Decoder");
                                                        break;
                                                }
                                                break;
                                        }
                                    } else {
                                        this.f12749m.a((char) 8480);
                                    }
                                    i = 2;
                                    z10 = true;
                                } else if (i42 > 159) {
                                    i = 2;
                                    if (i42 <= 255) {
                                        if (i42 == 160) {
                                            this.f12749m.a((char) 13252);
                                        } else {
                                            e6.j.p(i42, "Invalid G3 character: ", "Cea708Decoder");
                                            this.f12749m.a('_');
                                        }
                                        z10 = true;
                                    } else {
                                        e6.j.p(i42, "Invalid extended command: ", "Cea708Decoder");
                                    }
                                } else if (i42 <= 135) {
                                    tVar3.t(32);
                                } else if (i42 <= 143) {
                                    tVar3.t(40);
                                } else if (i42 <= 159) {
                                    i = 2;
                                    tVar3.t(2);
                                    tVar3.t(tVar3.i(6) * 8);
                                }
                            }
                            i = 2;
                        }
                        i10 = i;
                    }
                }
            }
        }
        if (z10) {
            this.f12750n = g();
        }
        this.f12752p = null;
    }

    @Override // u3.i, y1.d
    public final void flush() {
        super.flush();
        this.f12750n = null;
        this.f12751o = null;
        this.f12753q = 0;
        this.f12749m = this.f12748l[0];
        h();
        this.f12752p = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List g() {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.f.g():java.util.List");
    }

    public final void h() {
        for (int i = 0; i < 8; i++) {
            this.f12748l[i].d();
        }
    }
}
