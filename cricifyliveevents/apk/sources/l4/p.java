package l4;

import android.accounts.Account;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.versionedparcelable.ParcelImpl;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Locale;
import o.m0;
import qb.t1;
import v4.c1;
import v4.d1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7751a;

    public /* synthetic */ p(int i) {
        this.f7751a = i;
    }

    public static void a(o8.g gVar, Parcel parcel, int i) {
        int iW = t1.w(parcel, 20293);
        int i10 = gVar.f9659v;
        t1.v(parcel, 1, 4);
        parcel.writeInt(i10);
        int i11 = gVar.f9660w;
        t1.v(parcel, 2, 4);
        parcel.writeInt(i11);
        int i12 = gVar.f9661x;
        t1.v(parcel, 3, 4);
        parcel.writeInt(i12);
        t1.r(parcel, 4, gVar.f9662y);
        t1.p(parcel, 5, gVar.f9663z);
        t1.s(parcel, 6, gVar.A, i);
        t1.o(parcel, 7, gVar.B);
        t1.q(parcel, 8, gVar.C, i);
        t1.s(parcel, 10, gVar.D, i);
        t1.s(parcel, 11, gVar.E, i);
        boolean z10 = gVar.F;
        t1.v(parcel, 12, 4);
        parcel.writeInt(z10 ? 1 : 0);
        int i13 = gVar.G;
        t1.v(parcel, 13, 4);
        parcel.writeInt(i13);
        boolean z11 = gVar.H;
        t1.v(parcel, 14, 4);
        parcel.writeInt(z11 ? 1 : 0);
        t1.r(parcel, 15, gVar.I);
        t1.y(parcel, iW);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f7751a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new r(parcel);
            case 1:
                return new z(parcel);
            case 2:
                a0 a0Var = new a0();
                a0Var.f7698v = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                return a0Var;
            case 3:
                MediaSession.Token token = (MediaSession.Token) parcel.readParcelable(null);
                token.getClass();
                return new b0(token, null);
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                i0 i0Var = new i0();
                i0Var.f7720v = parcel.readInt();
                i0Var.f7722x = parcel.readInt();
                i0Var.f7723y = parcel.readInt();
                i0Var.f7724z = parcel.readInt();
                i0Var.f7721w = parcel.readInt();
                return i0Var;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return new k0(parcel);
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return new j0(parcel);
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return new l0(parcel.readInt(), parcel.readFloat());
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                int iO = n5.a.O(parcel);
                PendingIntent pendingIntent = null;
                int iF = 0;
                int iF2 = 0;
                String strJ = null;
                while (parcel.dataPosition() < iO) {
                    int i = parcel.readInt();
                    char c9 = (char) i;
                    if (c9 == 1) {
                        iF = n5.a.F(parcel, i);
                    } else if (c9 == 2) {
                        iF2 = n5.a.F(parcel, i);
                    } else if (c9 == 3) {
                        pendingIntent = (PendingIntent) n5.a.i(parcel, i, PendingIntent.CREATOR);
                    } else if (c9 != 4) {
                        n5.a.K(parcel, i);
                    } else {
                        strJ = n5.a.j(parcel, i);
                    }
                }
                n5.a.m(parcel, iO);
                return new l8.b(iF, iF2, pendingIntent, strJ);
            case 9:
                int iO2 = n5.a.O(parcel);
                long jG = -1;
                int iF3 = 0;
                String strJ2 = null;
                while (parcel.dataPosition() < iO2) {
                    int i10 = parcel.readInt();
                    char c10 = (char) i10;
                    if (c10 == 1) {
                        strJ2 = n5.a.j(parcel, i10);
                    } else if (c10 == 2) {
                        iF3 = n5.a.F(parcel, i10);
                    } else if (c10 != 3) {
                        n5.a.K(parcel, i10);
                    } else {
                        jG = n5.a.G(parcel, i10);
                    }
                }
                n5.a.m(parcel, iO2);
                return new l8.d(iF3, jG, strJ2);
            case 10:
                int iO3 = n5.a.O(parcel);
                long jG2 = -1;
                boolean zE = false;
                int iF4 = 0;
                int iF5 = 0;
                String strJ3 = null;
                while (parcel.dataPosition() < iO3) {
                    int i11 = parcel.readInt();
                    char c11 = (char) i11;
                    if (c11 == 1) {
                        zE = n5.a.E(parcel, i11);
                    } else if (c11 == 2) {
                        strJ3 = n5.a.j(parcel, i11);
                    } else if (c11 == 3) {
                        iF4 = n5.a.F(parcel, i11);
                    } else if (c11 == 4) {
                        iF5 = n5.a.F(parcel, i11);
                    } else if (c11 != 5) {
                        n5.a.K(parcel, i11);
                    } else {
                        jG2 = n5.a.G(parcel, i11);
                    }
                }
                n5.a.m(parcel, iO3);
                return new l8.s(zE, strJ3, iF4, iF5, jG2);
            case 11:
                int iO4 = n5.a.O(parcel);
                String strJ4 = null;
                int iF6 = 0;
                while (parcel.dataPosition() < iO4) {
                    int i12 = parcel.readInt();
                    char c12 = (char) i12;
                    if (c12 == 1) {
                        iF6 = n5.a.F(parcel, i12);
                    } else if (c12 != 2) {
                        n5.a.K(parcel, i12);
                    } else {
                        strJ4 = n5.a.j(parcel, i12);
                    }
                }
                n5.a.m(parcel, iO4);
                return new Scope(iF6, strJ4);
            case 12:
                int iO5 = n5.a.O(parcel);
                String strJ5 = null;
                l8.b bVar = null;
                int iF7 = 0;
                PendingIntent pendingIntent2 = null;
                while (parcel.dataPosition() < iO5) {
                    int i13 = parcel.readInt();
                    char c13 = (char) i13;
                    if (c13 == 1) {
                        iF7 = n5.a.F(parcel, i13);
                    } else if (c13 == 2) {
                        strJ5 = n5.a.j(parcel, i13);
                    } else if (c13 == 3) {
                        pendingIntent2 = (PendingIntent) n5.a.i(parcel, i13, PendingIntent.CREATOR);
                    } else if (c13 != 4) {
                        n5.a.K(parcel, i13);
                    } else {
                        bVar = (l8.b) n5.a.i(parcel, i13, l8.b.CREATOR);
                    }
                }
                n5.a.m(parcel, iO5);
                return new Status(iF7, strJ5, pendingIntent2, bVar);
            case 13:
                return new ParcelImpl(parcel);
            case 14:
                n9.b bVar2 = new n9.b();
                bVar2.D = 255;
                bVar2.F = -2;
                bVar2.G = -2;
                bVar2.H = -2;
                bVar2.O = Boolean.TRUE;
                bVar2.f8906v = parcel.readInt();
                bVar2.f8907w = (Integer) parcel.readSerializable();
                bVar2.f8908x = (Integer) parcel.readSerializable();
                bVar2.f8909y = (Integer) parcel.readSerializable();
                bVar2.f8910z = (Integer) parcel.readSerializable();
                bVar2.A = (Integer) parcel.readSerializable();
                bVar2.B = (Integer) parcel.readSerializable();
                bVar2.C = (Integer) parcel.readSerializable();
                bVar2.D = parcel.readInt();
                bVar2.E = parcel.readString();
                bVar2.F = parcel.readInt();
                bVar2.G = parcel.readInt();
                bVar2.H = parcel.readInt();
                bVar2.J = parcel.readString();
                bVar2.K = parcel.readString();
                bVar2.L = parcel.readInt();
                bVar2.N = (Integer) parcel.readSerializable();
                bVar2.P = (Integer) parcel.readSerializable();
                bVar2.Q = (Integer) parcel.readSerializable();
                bVar2.R = (Integer) parcel.readSerializable();
                bVar2.S = (Integer) parcel.readSerializable();
                bVar2.T = (Integer) parcel.readSerializable();
                bVar2.U = (Integer) parcel.readSerializable();
                bVar2.X = (Integer) parcel.readSerializable();
                bVar2.V = (Integer) parcel.readSerializable();
                bVar2.W = (Integer) parcel.readSerializable();
                bVar2.O = (Boolean) parcel.readSerializable();
                bVar2.I = (Locale) parcel.readSerializable();
                bVar2.Y = (Boolean) parcel.readSerializable();
                bVar2.Z = (Integer) parcel.readSerializable();
                return bVar2;
            case 15:
                int iO6 = n5.a.O(parcel);
                Bundle bundleG = null;
                while (parcel.dataPosition() < iO6) {
                    int i14 = parcel.readInt();
                    if (((char) i14) != 2) {
                        n5.a.K(parcel, i14);
                    } else {
                        bundleG = n5.a.g(parcel, i14);
                    }
                }
                n5.a.m(parcel, iO6);
                return new nc.o(bundleG);
            case 16:
                o.j jVar = new o.j();
                jVar.f9246v = parcel.readInt();
                return jVar;
            case 17:
                m0 m0Var = new m0(parcel);
                m0Var.f9274v = parcel.readByte() != 0;
                return m0Var;
            case 18:
                int iO7 = n5.a.O(parcel);
                ArrayList arrayListL = null;
                int iF8 = 0;
                while (parcel.dataPosition() < iO7) {
                    int i15 = parcel.readInt();
                    char c14 = (char) i15;
                    if (c14 == 1) {
                        iF8 = n5.a.F(parcel, i15);
                    } else if (c14 != 2) {
                        n5.a.K(parcel, i15);
                    } else {
                        arrayListL = n5.a.l(parcel, i15, o8.i.CREATOR);
                    }
                }
                n5.a.m(parcel, iO7);
                return new o8.l(iF8, arrayListL);
            case 19:
                int iO8 = n5.a.O(parcel);
                int iF9 = -1;
                int iF10 = 0;
                int iF11 = 0;
                int iF12 = 0;
                int iF13 = 0;
                String strJ6 = null;
                String strJ7 = null;
                long jG3 = 0;
                long jG4 = 0;
                while (parcel.dataPosition() < iO8) {
                    int i16 = parcel.readInt();
                    switch ((char) i16) {
                        case 1:
                            iF10 = n5.a.F(parcel, i16);
                            break;
                        case 2:
                            iF11 = n5.a.F(parcel, i16);
                            break;
                        case 3:
                            iF12 = n5.a.F(parcel, i16);
                            break;
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            jG3 = n5.a.G(parcel, i16);
                            break;
                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            jG4 = n5.a.G(parcel, i16);
                            break;
                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                            strJ6 = n5.a.j(parcel, i16);
                            break;
                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                            strJ7 = n5.a.j(parcel, i16);
                            break;
                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                            iF13 = n5.a.F(parcel, i16);
                            break;
                        case '\t':
                            iF9 = n5.a.F(parcel, i16);
                            break;
                        default:
                            n5.a.K(parcel, i16);
                            break;
                    }
                }
                n5.a.m(parcel, iO8);
                return new o8.i(iF10, iF11, iF12, jG3, jG4, strJ6, strJ7, iF13, iF9);
            case 20:
                int iO9 = n5.a.O(parcel);
                int iF14 = 0;
                boolean zE2 = false;
                boolean zE3 = false;
                int iF15 = 0;
                int iF16 = 0;
                while (parcel.dataPosition() < iO9) {
                    int i17 = parcel.readInt();
                    char c15 = (char) i17;
                    if (c15 == 1) {
                        iF14 = n5.a.F(parcel, i17);
                    } else if (c15 == 2) {
                        zE2 = n5.a.E(parcel, i17);
                    } else if (c15 == 3) {
                        zE3 = n5.a.E(parcel, i17);
                    } else if (c15 == 4) {
                        iF15 = n5.a.F(parcel, i17);
                    } else if (c15 != 5) {
                        n5.a.K(parcel, i17);
                    } else {
                        iF16 = n5.a.F(parcel, i17);
                    }
                }
                n5.a.m(parcel, iO9);
                return new o8.k(iF14, zE2, zE3, iF15, iF16);
            case 21:
                int iO10 = n5.a.O(parcel);
                Bundle bundleG2 = null;
                o8.f fVar = null;
                int iF17 = 0;
                l8.d[] dVarArr = null;
                while (parcel.dataPosition() < iO10) {
                    int i18 = parcel.readInt();
                    char c16 = (char) i18;
                    if (c16 == 1) {
                        bundleG2 = n5.a.g(parcel, i18);
                    } else if (c16 == 2) {
                        dVarArr = (l8.d[]) n5.a.k(parcel, i18, l8.d.CREATOR);
                    } else if (c16 == 3) {
                        iF17 = n5.a.F(parcel, i18);
                    } else if (c16 != 4) {
                        n5.a.K(parcel, i18);
                    } else {
                        fVar = (o8.f) n5.a.i(parcel, i18, o8.f.CREATOR);
                    }
                }
                n5.a.m(parcel, iO10);
                o8.c0 c0Var = new o8.c0();
                c0Var.f9613v = bundleG2;
                c0Var.f9614w = dVarArr;
                c0Var.f9615x = iF17;
                c0Var.f9616y = fVar;
                return c0Var;
            case 22:
                int iO11 = n5.a.O(parcel);
                o8.k kVar = null;
                int[] iArrCreateIntArray = null;
                int[] iArrCreateIntArray2 = null;
                boolean zE4 = false;
                boolean zE5 = false;
                int iF18 = 0;
                while (parcel.dataPosition() < iO11) {
                    int i19 = parcel.readInt();
                    switch ((char) i19) {
                        case 1:
                            kVar = (o8.k) n5.a.i(parcel, i19, o8.k.CREATOR);
                            break;
                        case 2:
                            zE4 = n5.a.E(parcel, i19);
                            break;
                        case 3:
                            zE5 = n5.a.E(parcel, i19);
                            break;
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            int iH = n5.a.H(parcel, i19);
                            int iDataPosition = parcel.dataPosition();
                            if (iH != 0) {
                                iArrCreateIntArray = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition + iH);
                            } else {
                                iArrCreateIntArray = null;
                            }
                            break;
                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            iF18 = n5.a.F(parcel, i19);
                            break;
                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                            int iH2 = n5.a.H(parcel, i19);
                            int iDataPosition2 = parcel.dataPosition();
                            if (iH2 != 0) {
                                iArrCreateIntArray2 = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition2 + iH2);
                            } else {
                                iArrCreateIntArray2 = null;
                            }
                            break;
                        default:
                            n5.a.K(parcel, i19);
                            break;
                    }
                }
                n5.a.m(parcel, iO11);
                return new o8.f(kVar, zE4, zE5, iArrCreateIntArray, iF18, iArrCreateIntArray2);
            case 23:
                int iO12 = n5.a.O(parcel);
                Bundle bundle = new Bundle();
                Scope[] scopeArr = o8.g.J;
                String strJ8 = null;
                IBinder iBinder = null;
                Account account = null;
                String strJ9 = null;
                int iF19 = 0;
                int iF20 = 0;
                int iF21 = 0;
                boolean zE6 = false;
                int iF22 = 0;
                boolean zE7 = false;
                l8.d[] dVarArr2 = o8.g.K;
                l8.d[] dVarArr3 = dVarArr2;
                while (parcel.dataPosition() < iO12) {
                    int i20 = parcel.readInt();
                    switch ((char) i20) {
                        case 1:
                            iF19 = n5.a.F(parcel, i20);
                            break;
                        case 2:
                            iF20 = n5.a.F(parcel, i20);
                            break;
                        case 3:
                            iF21 = n5.a.F(parcel, i20);
                            break;
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            strJ8 = n5.a.j(parcel, i20);
                            break;
                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            int iH3 = n5.a.H(parcel, i20);
                            int iDataPosition3 = parcel.dataPosition();
                            if (iH3 != 0) {
                                IBinder strongBinder = parcel.readStrongBinder();
                                parcel.setDataPosition(iDataPosition3 + iH3);
                                iBinder = strongBinder;
                            } else {
                                iBinder = null;
                            }
                            break;
                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                            scopeArr = (Scope[]) n5.a.k(parcel, i20, Scope.CREATOR);
                            break;
                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                            bundle = n5.a.g(parcel, i20);
                            break;
                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                            account = (Account) n5.a.i(parcel, i20, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            n5.a.K(parcel, i20);
                            break;
                        case '\n':
                            dVarArr2 = (l8.d[]) n5.a.k(parcel, i20, l8.d.CREATOR);
                            break;
                        case 11:
                            dVarArr3 = (l8.d[]) n5.a.k(parcel, i20, l8.d.CREATOR);
                            break;
                        case '\f':
                            zE6 = n5.a.E(parcel, i20);
                            break;
                        case '\r':
                            iF22 = n5.a.F(parcel, i20);
                            break;
                        case 14:
                            zE7 = n5.a.E(parcel, i20);
                            break;
                        case 15:
                            strJ9 = n5.a.j(parcel, i20);
                            break;
                    }
                }
                n5.a.m(parcel, iO12);
                return new o8.g(iF19, iF20, iF21, strJ8, iBinder, scopeArr, bundle, account, dVarArr2, dVarArr3, zE6, iF22, zE7, strJ9);
            case 24:
                u9.b bVar3 = new u9.b(parcel);
                bVar3.f12293v = ((Integer) parcel.readValue(u9.b.class.getClassLoader())).intValue();
                return bVar3;
            case 25:
                v4.r rVar = new v4.r();
                rVar.f13337v = parcel.readInt();
                rVar.f13338w = parcel.readInt();
                rVar.f13339x = parcel.readInt() == 1;
                return rVar;
            case 26:
                c1 c1Var = new c1();
                c1Var.f13193v = parcel.readInt();
                c1Var.f13194w = parcel.readInt();
                c1Var.f13196y = parcel.readInt() == 1;
                int i21 = parcel.readInt();
                if (i21 > 0) {
                    int[] iArr = new int[i21];
                    c1Var.f13195x = iArr;
                    parcel.readIntArray(iArr);
                }
                return c1Var;
            case 27:
                d1 d1Var = new d1();
                d1Var.f13202v = parcel.readInt();
                d1Var.f13203w = parcel.readInt();
                int i22 = parcel.readInt();
                d1Var.f13204x = i22;
                if (i22 > 0) {
                    int[] iArr2 = new int[i22];
                    d1Var.f13205y = iArr2;
                    parcel.readIntArray(iArr2);
                }
                int i23 = parcel.readInt();
                d1Var.f13206z = i23;
                if (i23 > 0) {
                    int[] iArr3 = new int[i23];
                    d1Var.A = iArr3;
                    parcel.readIntArray(iArr3);
                }
                d1Var.C = parcel.readInt() == 1;
                d1Var.D = parcel.readInt() == 1;
                d1Var.E = parcel.readInt() == 1;
                d1Var.B = parcel.readArrayList(c1.class.getClassLoader());
                return d1Var;
            case 28:
                x0.g gVar = new x0.g(parcel);
                gVar.f14219v = parcel.readInt();
                return gVar;
            default:
                y5.a aVar = new y5.a();
                aVar.f14906x = "https://t.me/playztv";
                aVar.f14907y = "Notice text will be show here.";
                aVar.f14908z = "https://playztv.online/";
                aVar.A = "https://playztv.online/";
                aVar.B = "PlayZ Tv, we are still working on it to provide more better result.";
                aVar.C = "https://t.me/playztv";
                aVar.D = "";
                aVar.E = "";
                aVar.F = "no";
                aVar.G = "no";
                aVar.H = "no";
                aVar.I = "no";
                aVar.J = "test@gmail.com";
                aVar.K = "no";
                aVar.L = "";
                aVar.M = "";
                aVar.N = "";
                aVar.O = 10;
                aVar.P = 12;
                aVar.Q = 1;
                aVar.f14906x = parcel.readString();
                aVar.f14907y = parcel.readString();
                aVar.f14908z = parcel.readString();
                aVar.A = parcel.readString();
                aVar.B = parcel.readString();
                aVar.C = parcel.readString();
                aVar.D = parcel.readString();
                aVar.E = parcel.readString();
                aVar.F = parcel.readString();
                aVar.G = parcel.readString();
                aVar.H = parcel.readString();
                aVar.I = parcel.readString();
                aVar.J = parcel.readString();
                aVar.K = parcel.readString();
                aVar.f14904v = parcel.readString();
                aVar.f14905w = parcel.readString();
                aVar.L = parcel.readString();
                aVar.M = parcel.readString();
                aVar.N = parcel.readString();
                aVar.O = parcel.readInt();
                aVar.P = parcel.readInt();
                aVar.Q = parcel.readInt();
                return aVar;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f7751a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new r[i];
            case 1:
                return new z[i];
            case 2:
                return new a0[i];
            case 3:
                return new b0[i];
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return new i0[i];
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return new k0[i];
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return new j0[i];
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return new l0[i];
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                return new l8.b[i];
            case 9:
                return new l8.d[i];
            case 10:
                return new l8.s[i];
            case 11:
                return new Scope[i];
            case 12:
                return new Status[i];
            case 13:
                return new ParcelImpl[i];
            case 14:
                return new n9.b[i];
            case 15:
                return new nc.o[i];
            case 16:
                return new o.j[i];
            case 17:
                return new m0[i];
            case 18:
                return new o8.l[i];
            case 19:
                return new o8.i[i];
            case 20:
                return new o8.k[i];
            case 21:
                return new o8.c0[i];
            case 22:
                return new o8.f[i];
            case 23:
                return new o8.g[i];
            case 24:
                return new u9.b[i];
            case 25:
                return new v4.r[i];
            case 26:
                return new c1[i];
            case 27:
                return new d1[i];
            case 28:
                return new x0.g[i];
            default:
                return new y5.a[i];
        }
    }
}
