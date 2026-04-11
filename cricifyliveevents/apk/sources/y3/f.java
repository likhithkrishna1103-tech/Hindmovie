package y3;

import a3.k0;
import android.text.SpannableStringBuilder;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import j9.q;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t f14821h = new t();
    public final k0 i = new k0();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14822j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f14823k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e[] f14824l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e f14825m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f14826n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List f14827o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public k0 f14828p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14829q;

    public f(int i, List list) {
        this.f14823k = i == -1 ? 1 : i;
        if (list != null) {
            byte[] bArr = y1.e.f14568a;
            if (list.size() == 1 && ((byte[]) list.get(0)).length == 1) {
                byte b8 = ((byte[]) list.get(0))[0];
            }
        }
        this.f14824l = new e[8];
        for (int i10 = 0; i10 < 8; i10++) {
            this.f14824l[i10] = new e();
        }
        this.f14825m = this.f14824l[0];
    }

    @Override // y3.i
    public final q b() {
        List list = this.f14826n;
        this.f14827o = list;
        list.getClass();
        return new q(list);
    }

    @Override // y3.i
    public final void c(g gVar) {
        ByteBuffer byteBuffer = gVar.data;
        byteBuffer.getClass();
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        t tVar = this.f14821h;
        tVar.H(iLimit, bArrArray);
        while (tVar.a() >= 3) {
            int iX = tVar.x();
            int i = iX & 3;
            boolean z10 = (iX & 4) == 4;
            byte bX = (byte) tVar.x();
            byte bX2 = (byte) tVar.x();
            if (i == 2 || i == 3) {
                if (z10) {
                    if (i == 3) {
                        f();
                        int i10 = (bX & 192) >> 6;
                        int i11 = this.f14822j;
                        if (i11 != -1 && i10 != (i11 + 1) % 4) {
                            h();
                            y1.b.p("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f14822j + " current=" + i10);
                        }
                        this.f14822j = i10;
                        int i12 = bX & 63;
                        if (i12 == 0) {
                            i12 = 64;
                        }
                        k0 k0Var = new k0(i10, i12);
                        this.f14828p = k0Var;
                        byte[] bArr = k0Var.f208b;
                        k0Var.f211e = 1;
                        bArr[0] = bX2;
                    } else {
                        y1.d.b(i == 2);
                        k0 k0Var2 = this.f14828p;
                        if (k0Var2 == null) {
                            y1.b.g("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = k0Var2.f208b;
                            int i13 = k0Var2.f211e;
                            int i14 = i13 + 1;
                            k0Var2.f211e = i14;
                            bArr2[i13] = bX;
                            k0Var2.f211e = i13 + 2;
                            bArr2[i14] = bX2;
                        }
                    }
                    k0 k0Var3 = this.f14828p;
                    if (k0Var3.f211e == (k0Var3.f210d * 2) - 1) {
                        f();
                    }
                }
            }
        }
    }

    @Override // y3.i
    public final boolean e() {
        return this.f14826n != this.f14827o;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void f() {
        char c9;
        int i;
        boolean z10;
        k0 k0Var = this.f14828p;
        if (k0Var == null) {
            return;
        }
        int i10 = 2;
        if (k0Var.f211e != (k0Var.f210d * 2) - 1) {
            y1.b.f("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f14828p.f210d * 2) - 1) + ", but current index is " + this.f14828p.f211e + " (sequence number " + this.f14828p.f209c + ");");
        }
        k0 k0Var2 = this.f14828p;
        byte[] bArr = k0Var2.f208b;
        int i11 = k0Var2.f211e;
        k0 k0Var3 = this.i;
        k0Var3.o(i11, bArr);
        boolean z11 = false;
        while (true) {
            if (k0Var3.b() > 0) {
                int i12 = 3;
                int i13 = k0Var3.i(3);
                int i14 = k0Var3.i(5);
                if (i13 == 7) {
                    k0Var3.t(i10);
                    i13 = k0Var3.i(6);
                    if (i13 < 7) {
                        l0.e.p(i13, "Invalid extended service number: ", "Cea708Decoder");
                    }
                }
                if (i14 == 0) {
                    if (i13 != 0) {
                        y1.b.p("Cea708Decoder", "serviceNumber is non-zero (" + i13 + ") when blockSize is 0");
                    }
                } else if (i13 != this.f14823k) {
                    k0Var3.u(i14);
                } else {
                    int iG = (i14 * 8) + k0Var3.g();
                    while (k0Var3.g() < iG) {
                        int i15 = k0Var3.i(8);
                        if (i15 != 16) {
                            if (i15 <= 31) {
                                if (i15 != 0) {
                                    if (i15 == i12) {
                                        this.f14826n = g();
                                    } else if (i15 != 8) {
                                        switch (i15) {
                                            case 12:
                                                h();
                                                break;
                                            case 13:
                                                this.f14825m.a('\n');
                                                break;
                                            case 14:
                                                break;
                                            default:
                                                if (i15 >= 17 && i15 <= 23) {
                                                    y1.b.p("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i15);
                                                    k0Var3.t(8);
                                                } else if (i15 < 24 || i15 > 31) {
                                                    l0.e.p(i15, "Invalid C0 command: ", "Cea708Decoder");
                                                } else {
                                                    y1.b.p("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i15);
                                                    k0Var3.t(16);
                                                }
                                                break;
                                        }
                                    } else {
                                        SpannableStringBuilder spannableStringBuilder = this.f14825m.f14803b;
                                        int length = spannableStringBuilder.length();
                                        if (length > 0) {
                                            spannableStringBuilder.delete(length - 1, length);
                                        }
                                    }
                                }
                                i = i10;
                            } else if (i15 <= 127) {
                                if (i15 == 127) {
                                    this.f14825m.a((char) 9835);
                                } else {
                                    this.f14825m.a((char) (i15 & 255));
                                }
                                i = i10;
                                z11 = true;
                            } else {
                                if (i15 <= 159) {
                                    e[] eVarArr = this.f14824l;
                                    switch (i15) {
                                        case 128:
                                        case 129:
                                        case 130:
                                        case 131:
                                        case 132:
                                        case 133:
                                        case 134:
                                        case 135:
                                            z10 = true;
                                            int i16 = i15 - 128;
                                            if (this.f14829q != i16) {
                                                this.f14829q = i16;
                                                this.f14825m = eVarArr[i16];
                                            }
                                            break;
                                        case 136:
                                            z10 = true;
                                            for (int i17 = 1; i17 <= 8; i17++) {
                                                if (k0Var3.h()) {
                                                    e eVar = eVarArr[8 - i17];
                                                    eVar.f14802a.clear();
                                                    eVar.f14803b.clear();
                                                    eVar.f14814o = -1;
                                                    eVar.f14815p = -1;
                                                    eVar.f14816q = -1;
                                                    eVar.f14818s = -1;
                                                    eVar.f14820u = 0;
                                                }
                                            }
                                            break;
                                        case 137:
                                            for (int i18 = 1; i18 <= 8; i18++) {
                                                if (k0Var3.h()) {
                                                    eVarArr[8 - i18].f14805d = true;
                                                }
                                            }
                                            z10 = true;
                                            break;
                                        case 138:
                                            for (int i19 = 1; i19 <= 8; i19++) {
                                                if (k0Var3.h()) {
                                                    eVarArr[8 - i19].f14805d = false;
                                                }
                                            }
                                            z10 = true;
                                            break;
                                        case 139:
                                            for (int i20 = 1; i20 <= 8; i20++) {
                                                if (k0Var3.h()) {
                                                    eVarArr[8 - i20].f14805d = !r1.f14805d;
                                                }
                                            }
                                            z10 = true;
                                            break;
                                        case 140:
                                            for (int i21 = 1; i21 <= 8; i21++) {
                                                if (k0Var3.h()) {
                                                    eVarArr[8 - i21].d();
                                                }
                                            }
                                            z10 = true;
                                            break;
                                        case 141:
                                            k0Var3.t(8);
                                            z10 = true;
                                            break;
                                        case 142:
                                            z10 = true;
                                            break;
                                        case 143:
                                            h();
                                            z10 = true;
                                            break;
                                        case 144:
                                            int i22 = i10;
                                            if (this.f14825m.f14804c) {
                                                k0Var3.i(4);
                                                k0Var3.i(i22);
                                                k0Var3.i(i22);
                                                boolean zH = k0Var3.h();
                                                boolean zH2 = k0Var3.h();
                                                i12 = 3;
                                                k0Var3.i(3);
                                                k0Var3.i(3);
                                                this.f14825m.e(zH, zH2);
                                                z10 = true;
                                            } else {
                                                k0Var3.t(16);
                                                z10 = true;
                                                i12 = 3;
                                            }
                                            break;
                                        case 145:
                                            if (this.f14825m.f14804c) {
                                                int iC = e.c(k0Var3.i(2), k0Var3.i(2), k0Var3.i(2), k0Var3.i(2));
                                                int iC2 = e.c(k0Var3.i(2), k0Var3.i(2), k0Var3.i(2), k0Var3.i(2));
                                                k0Var3.t(2);
                                                e.c(k0Var3.i(2), k0Var3.i(2), k0Var3.i(2), 0);
                                                this.f14825m.f(iC, iC2);
                                            } else {
                                                k0Var3.t(24);
                                            }
                                            z10 = true;
                                            i12 = 3;
                                            break;
                                        case 146:
                                            if (this.f14825m.f14804c) {
                                                k0Var3.t(4);
                                                int i23 = k0Var3.i(4);
                                                k0Var3.t(2);
                                                k0Var3.i(6);
                                                e eVar2 = this.f14825m;
                                                if (eVar2.f14820u != i23) {
                                                    eVar2.a('\n');
                                                }
                                                eVar2.f14820u = i23;
                                            } else {
                                                k0Var3.t(16);
                                            }
                                            z10 = true;
                                            i12 = 3;
                                            break;
                                        case 147:
                                        case 148:
                                        case 149:
                                        case 150:
                                        default:
                                            l0.e.p(i15, "Invalid C1 command: ", "Cea708Decoder");
                                            z10 = true;
                                            break;
                                        case 151:
                                            if (this.f14825m.f14804c) {
                                                int iC3 = e.c(k0Var3.i(2), k0Var3.i(2), k0Var3.i(2), k0Var3.i(2));
                                                k0Var3.i(2);
                                                e.c(k0Var3.i(2), k0Var3.i(2), k0Var3.i(2), 0);
                                                k0Var3.h();
                                                k0Var3.h();
                                                k0Var3.i(2);
                                                k0Var3.i(2);
                                                int i24 = k0Var3.i(2);
                                                k0Var3.t(8);
                                                e eVar3 = this.f14825m;
                                                eVar3.f14813n = iC3;
                                                eVar3.f14810k = i24;
                                            } else {
                                                k0Var3.t(32);
                                            }
                                            z10 = true;
                                            i12 = 3;
                                            break;
                                        case 152:
                                        case 153:
                                        case 154:
                                        case ModuleDescriptor.MODULE_VERSION /* 155 */:
                                        case 156:
                                        case 157:
                                        case 158:
                                        case 159:
                                            int i25 = i15 - 152;
                                            e eVar4 = eVarArr[i25];
                                            k0Var3.t(i10);
                                            boolean zH3 = k0Var3.h();
                                            k0Var3.t(i10);
                                            int i26 = k0Var3.i(i12);
                                            boolean zH4 = k0Var3.h();
                                            int i27 = k0Var3.i(7);
                                            int i28 = k0Var3.i(8);
                                            int i29 = k0Var3.i(4);
                                            int i30 = k0Var3.i(4);
                                            k0Var3.t(i10);
                                            k0Var3.t(6);
                                            k0Var3.t(i10);
                                            int i31 = k0Var3.i(3);
                                            int i32 = k0Var3.i(3);
                                            ArrayList arrayList = eVar4.f14802a;
                                            eVar4.f14804c = true;
                                            eVar4.f14805d = zH3;
                                            eVar4.f14806e = i26;
                                            eVar4.f = zH4;
                                            eVar4.f14807g = i27;
                                            eVar4.f14808h = i28;
                                            eVar4.i = i29;
                                            int i33 = i30 + 1;
                                            if (eVar4.f14809j != i33) {
                                                eVar4.f14809j = i33;
                                                while (true) {
                                                    if (arrayList.size() >= eVar4.f14809j || arrayList.size() >= 15) {
                                                        arrayList.remove(0);
                                                    }
                                                }
                                            }
                                            if (i31 != 0 && eVar4.f14811l != i31) {
                                                eVar4.f14811l = i31;
                                                int i34 = i31 - 1;
                                                int i35 = e.B[i34];
                                                boolean z12 = e.A[i34];
                                                int i36 = e.f14800y[i34];
                                                int i37 = e.f14801z[i34];
                                                int i38 = e.f14799x[i34];
                                                eVar4.f14813n = i35;
                                                eVar4.f14810k = i38;
                                            }
                                            if (i32 != 0 && eVar4.f14812m != i32) {
                                                eVar4.f14812m = i32;
                                                int i39 = i32 - 1;
                                                int i40 = e.D[i39];
                                                int i41 = e.C[i39];
                                                eVar4.e(false, false);
                                                eVar4.f(e.f14797v, e.E[i39]);
                                            }
                                            if (this.f14829q != i25) {
                                                this.f14829q = i25;
                                                this.f14825m = eVarArr[i25];
                                            }
                                            z10 = true;
                                            i12 = 3;
                                            break;
                                    }
                                } else {
                                    z10 = true;
                                    if (i15 <= 255) {
                                        this.f14825m.a((char) (i15 & 255));
                                    } else {
                                        l0.e.p(i15, "Invalid base command: ", "Cea708Decoder");
                                        i = 2;
                                        c9 = 7;
                                    }
                                }
                                z11 = z10;
                                i = 2;
                                c9 = 7;
                            }
                            c9 = 7;
                        } else {
                            int i42 = k0Var3.i(8);
                            if (i42 <= 31) {
                                c9 = 7;
                                if (i42 > 7) {
                                    if (i42 <= 15) {
                                        k0Var3.t(8);
                                    } else if (i42 <= 23) {
                                        k0Var3.t(16);
                                    } else if (i42 <= 31) {
                                        k0Var3.t(24);
                                    }
                                }
                            } else {
                                c9 = 7;
                                if (i42 <= 127) {
                                    if (i42 == 32) {
                                        this.f14825m.a(' ');
                                    } else if (i42 == 33) {
                                        this.f14825m.a((char) 160);
                                    } else if (i42 == 37) {
                                        this.f14825m.a((char) 8230);
                                    } else if (i42 == 42) {
                                        this.f14825m.a((char) 352);
                                    } else if (i42 == 44) {
                                        this.f14825m.a((char) 338);
                                    } else if (i42 == 63) {
                                        this.f14825m.a((char) 376);
                                    } else if (i42 == 57) {
                                        this.f14825m.a((char) 8482);
                                    } else if (i42 == 58) {
                                        this.f14825m.a((char) 353);
                                    } else if (i42 == 60) {
                                        this.f14825m.a((char) 339);
                                    } else if (i42 != 61) {
                                        switch (i42) {
                                            case 48:
                                                this.f14825m.a((char) 9608);
                                                break;
                                            case 49:
                                                this.f14825m.a((char) 8216);
                                                break;
                                            case 50:
                                                this.f14825m.a((char) 8217);
                                                break;
                                            case 51:
                                                this.f14825m.a((char) 8220);
                                                break;
                                            case 52:
                                                this.f14825m.a((char) 8221);
                                                break;
                                            case 53:
                                                this.f14825m.a((char) 8226);
                                                break;
                                            default:
                                                switch (i42) {
                                                    case 118:
                                                        this.f14825m.a((char) 8539);
                                                        break;
                                                    case 119:
                                                        this.f14825m.a((char) 8540);
                                                        break;
                                                    case 120:
                                                        this.f14825m.a((char) 8541);
                                                        break;
                                                    case 121:
                                                        this.f14825m.a((char) 8542);
                                                        break;
                                                    case 122:
                                                        this.f14825m.a((char) 9474);
                                                        break;
                                                    case 123:
                                                        this.f14825m.a((char) 9488);
                                                        break;
                                                    case 124:
                                                        this.f14825m.a((char) 9492);
                                                        break;
                                                    case 125:
                                                        this.f14825m.a((char) 9472);
                                                        break;
                                                    case 126:
                                                        this.f14825m.a((char) 9496);
                                                        break;
                                                    case 127:
                                                        this.f14825m.a((char) 9484);
                                                        break;
                                                    default:
                                                        l0.e.p(i42, "Invalid G2 character: ", "Cea708Decoder");
                                                        break;
                                                }
                                                break;
                                        }
                                    } else {
                                        this.f14825m.a((char) 8480);
                                    }
                                    i = 2;
                                    z11 = true;
                                } else if (i42 > 159) {
                                    i = 2;
                                    if (i42 <= 255) {
                                        if (i42 == 160) {
                                            this.f14825m.a((char) 13252);
                                        } else {
                                            l0.e.p(i42, "Invalid G3 character: ", "Cea708Decoder");
                                            this.f14825m.a('_');
                                        }
                                        z11 = true;
                                    } else {
                                        l0.e.p(i42, "Invalid extended command: ", "Cea708Decoder");
                                    }
                                } else if (i42 <= 135) {
                                    k0Var3.t(32);
                                } else if (i42 <= 143) {
                                    k0Var3.t(40);
                                } else if (i42 <= 159) {
                                    i = 2;
                                    k0Var3.t(2);
                                    k0Var3.t(k0Var3.i(6) * 8);
                                }
                            }
                            i = 2;
                        }
                        i10 = i;
                    }
                }
            }
        }
        if (z11) {
            this.f14826n = g();
        }
        this.f14828p = null;
    }

    @Override // y3.i, e2.d
    public final void flush() {
        super.flush();
        this.f14826n = null;
        this.f14827o = null;
        this.f14829q = 0;
        this.f14825m = this.f14824l[0];
        h();
        this.f14828p = null;
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
        throw new UnsupportedOperationException("Method not decompiled: y3.f.g():java.util.List");
    }

    public final void h() {
        for (int i = 0; i < 8; i++) {
            this.f14824l[i].d();
        }
    }
}
