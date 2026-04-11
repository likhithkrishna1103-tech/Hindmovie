package k8;

import android.accounts.Account;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7533a;

    public /* synthetic */ x(int i) {
        this.f7533a = i;
    }

    public static void a(t7.g gVar, Parcel parcel, int i) {
        int iE = wa.t1.E(parcel, 20293);
        int i10 = gVar.f12300u;
        wa.t1.H(parcel, 1, 4);
        parcel.writeInt(i10);
        int i11 = gVar.f12301v;
        wa.t1.H(parcel, 2, 4);
        parcel.writeInt(i11);
        int i12 = gVar.f12302w;
        wa.t1.H(parcel, 3, 4);
        parcel.writeInt(i12);
        wa.t1.C(parcel, 4, gVar.f12303x);
        wa.t1.A(parcel, 5, gVar.f12304y);
        wa.t1.D(parcel, 6, gVar.f12305z, i);
        wa.t1.z(parcel, 7, gVar.A);
        wa.t1.B(parcel, 8, gVar.B, i);
        wa.t1.D(parcel, 10, gVar.C, i);
        wa.t1.D(parcel, 11, gVar.D, i);
        boolean z2 = gVar.E;
        wa.t1.H(parcel, 12, 4);
        parcel.writeInt(z2 ? 1 : 0);
        int i13 = gVar.F;
        wa.t1.H(parcel, 13, 4);
        parcel.writeInt(i13);
        boolean z10 = gVar.G;
        wa.t1.H(parcel, 14, 4);
        parcel.writeInt(z10 ? 1 : 0);
        wa.t1.C(parcel, 15, gVar.H);
        wa.t1.G(parcel, iE);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f7533a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int iV = q1.c.V(parcel);
                String strU = null;
                u uVar = null;
                String strU2 = null;
                long jK = 0;
                while (parcel.dataPosition() < iV) {
                    int i = parcel.readInt();
                    char c9 = (char) i;
                    if (c9 == 2) {
                        strU = q1.c.u(parcel, i);
                    } else if (c9 == 3) {
                        uVar = (u) q1.c.t(parcel, i, u.CREATOR);
                    } else if (c9 == 4) {
                        strU2 = q1.c.u(parcel, i);
                    } else if (c9 != 5) {
                        q1.c.R(parcel, i);
                    } else {
                        jK = q1.c.K(parcel, i);
                    }
                }
                q1.c.z(parcel, iV);
                return new v(strU, uVar, strU2, jK);
            case 1:
                int iV2 = q1.c.V(parcel);
                String strU3 = null;
                long jK2 = 0;
                int iJ = 0;
                while (parcel.dataPosition() < iV2) {
                    int i10 = parcel.readInt();
                    char c10 = (char) i10;
                    if (c10 == 1) {
                        strU3 = q1.c.u(parcel, i10);
                    } else if (c10 == 2) {
                        jK2 = q1.c.K(parcel, i10);
                    } else if (c10 != 3) {
                        q1.c.R(parcel, i10);
                    } else {
                        iJ = q1.c.J(parcel, i10);
                    }
                }
                q1.c.z(parcel, iV2);
                return new r3(iJ, jK2, strU3);
            case 2:
                int iV3 = q1.c.V(parcel);
                int iJ2 = 0;
                String strU4 = null;
                Long lValueOf = null;
                Float fValueOf = null;
                String strU5 = null;
                String strU6 = null;
                Double dValueOf = null;
                long jK3 = 0;
                while (parcel.dataPosition() < iV3) {
                    int i11 = parcel.readInt();
                    switch ((char) i11) {
                        case 1:
                            iJ2 = q1.c.J(parcel, i11);
                            break;
                        case 2:
                            strU4 = q1.c.u(parcel, i11);
                            break;
                        case 3:
                            jK3 = q1.c.K(parcel, i11);
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            int iL = q1.c.L(parcel, i11);
                            if (iL != 0) {
                                q1.c.W(parcel, iL, 8);
                                lValueOf = Long.valueOf(parcel.readLong());
                            } else {
                                lValueOf = null;
                            }
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            int iL2 = q1.c.L(parcel, i11);
                            if (iL2 != 0) {
                                q1.c.W(parcel, iL2, 4);
                                fValueOf = Float.valueOf(parcel.readFloat());
                            } else {
                                fValueOf = null;
                            }
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            strU5 = q1.c.u(parcel, i11);
                            break;
                        case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            strU6 = q1.c.u(parcel, i11);
                            break;
                        case '\b':
                            int iL3 = q1.c.L(parcel, i11);
                            if (iL3 != 0) {
                                q1.c.W(parcel, iL3, 8);
                                dValueOf = Double.valueOf(parcel.readDouble());
                            } else {
                                dValueOf = null;
                            }
                            break;
                        default:
                            q1.c.R(parcel, i11);
                            break;
                    }
                }
                q1.c.z(parcel, iV3);
                return new e4(iJ2, strU4, jK3, lValueOf, fValueOf, strU5, strU6, dValueOf);
            case 3:
                int iV4 = q1.c.V(parcel);
                String strU7 = null;
                String strU8 = null;
                String strU9 = null;
                String strU10 = null;
                String strU11 = null;
                String strU12 = null;
                String strU13 = null;
                Boolean boolValueOf = null;
                ArrayList<String> arrayList = null;
                String strU14 = null;
                String strU15 = null;
                String strU16 = null;
                long jK4 = 0;
                long jK5 = 0;
                long jK6 = 0;
                long jK7 = 0;
                long jK8 = 0;
                long jK9 = 0;
                long jK10 = 0;
                boolean zI = true;
                boolean zI2 = true;
                boolean zI3 = false;
                int iJ3 = 0;
                boolean zI4 = false;
                boolean zI5 = false;
                int iJ4 = 0;
                long jK11 = -2147483648L;
                String strU17 = "";
                String strU18 = strU17;
                String strU19 = strU18;
                String strU20 = strU19;
                int iJ5 = 100;
                while (parcel.dataPosition() < iV4) {
                    int i12 = parcel.readInt();
                    switch ((char) i12) {
                        case 2:
                            strU7 = q1.c.u(parcel, i12);
                            break;
                        case 3:
                            strU8 = q1.c.u(parcel, i12);
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            strU9 = q1.c.u(parcel, i12);
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            strU10 = q1.c.u(parcel, i12);
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            jK4 = q1.c.K(parcel, i12);
                            break;
                        case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            jK5 = q1.c.K(parcel, i12);
                            break;
                        case '\b':
                            strU11 = q1.c.u(parcel, i12);
                            break;
                        case '\t':
                            zI = q1.c.I(parcel, i12);
                            break;
                        case '\n':
                            zI3 = q1.c.I(parcel, i12);
                            break;
                        case 11:
                            jK11 = q1.c.K(parcel, i12);
                            break;
                        case '\f':
                            strU12 = q1.c.u(parcel, i12);
                            break;
                        case '\r':
                            jK6 = q1.c.K(parcel, i12);
                            break;
                        case 14:
                            jK7 = q1.c.K(parcel, i12);
                            break;
                        case 15:
                            iJ3 = q1.c.J(parcel, i12);
                            break;
                        case 16:
                            zI2 = q1.c.I(parcel, i12);
                            break;
                        case 17:
                        case 20:
                        case '!':
                        default:
                            q1.c.R(parcel, i12);
                            break;
                        case 18:
                            zI4 = q1.c.I(parcel, i12);
                            break;
                        case 19:
                            strU13 = q1.c.u(parcel, i12);
                            break;
                        case 21:
                            int iL4 = q1.c.L(parcel, i12);
                            if (iL4 != 0) {
                                q1.c.W(parcel, iL4, 4);
                                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
                            } else {
                                boolValueOf = null;
                            }
                            break;
                        case 22:
                            jK8 = q1.c.K(parcel, i12);
                            break;
                        case 23:
                            int iL5 = q1.c.L(parcel, i12);
                            int iDataPosition = parcel.dataPosition();
                            if (iL5 != 0) {
                                ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                                parcel.setDataPosition(iDataPosition + iL5);
                                arrayList = arrayListCreateStringArrayList;
                            } else {
                                arrayList = null;
                            }
                            break;
                        case 24:
                            strU14 = q1.c.u(parcel, i12);
                            break;
                        case 25:
                            strU17 = q1.c.u(parcel, i12);
                            break;
                        case 26:
                            strU18 = q1.c.u(parcel, i12);
                            break;
                        case 27:
                            strU15 = q1.c.u(parcel, i12);
                            break;
                        case 28:
                            zI5 = q1.c.I(parcel, i12);
                            break;
                        case 29:
                            jK9 = q1.c.K(parcel, i12);
                            break;
                        case 30:
                            iJ5 = q1.c.J(parcel, i12);
                            break;
                        case 31:
                            strU19 = q1.c.u(parcel, i12);
                            break;
                        case ' ':
                            iJ4 = q1.c.J(parcel, i12);
                            break;
                        case '\"':
                            jK10 = q1.c.K(parcel, i12);
                            break;
                        case '#':
                            strU16 = q1.c.u(parcel, i12);
                            break;
                        case '$':
                            strU20 = q1.c.u(parcel, i12);
                            break;
                    }
                }
                q1.c.z(parcel, iV4);
                return new a4(strU7, strU8, strU9, strU10, jK4, jK5, strU11, zI, zI3, jK11, strU12, jK6, jK7, iJ3, zI2, zI4, strU13, boolValueOf, jK8, arrayList, strU14, strU17, strU18, strU15, zI5, jK9, iJ5, strU19, iJ4, jK10, strU16, strU20);
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                l5.g gVar = new l5.g(parcel);
                gVar.f7839u = parcel.readString();
                gVar.f7841w = parcel.readFloat();
                gVar.f7842x = parcel.readInt() == 1;
                gVar.f7843y = parcel.readString();
                gVar.f7844z = parcel.readInt();
                gVar.A = parcel.readInt();
                return gVar;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                l9.h hVar = new l9.h();
                hVar.f8048u = parcel.readInt();
                hVar.f8049v = (j9.v) parcel.readParcelable(l9.h.class.getClassLoader());
                return hVar;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                n.j jVar = new n.j();
                jVar.f8413u = parcel.readInt();
                return jVar;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                n.o0 o0Var = new n.o0(parcel);
                o0Var.f8472u = parcel.readByte() != 0;
                return o0Var;
            case 8:
                oc.a aVar = new oc.a();
                aVar.f9505u = "https://t.me/playztv";
                aVar.f9506v = "Notice text will be show here.";
                aVar.f9507w = "https://playztv.online/";
                aVar.f9508x = "https://playztv.online/";
                aVar.f9509y = "PlayZ Tv, we are still working on it to provide more better result.";
                aVar.f9510z = "https://t.me/playztv";
                aVar.A = "";
                aVar.B = "";
                aVar.C = "no";
                aVar.D = "no";
                aVar.E = "no";
                aVar.F = "no";
                aVar.G = "test@gmail.com";
                aVar.H = "no";
                aVar.I = 1;
                aVar.f9505u = parcel.readString();
                aVar.f9506v = parcel.readString();
                aVar.f9507w = parcel.readString();
                aVar.f9508x = parcel.readString();
                aVar.f9509y = parcel.readString();
                aVar.f9510z = parcel.readString();
                aVar.A = parcel.readString();
                aVar.B = parcel.readString();
                aVar.C = parcel.readString();
                aVar.D = parcel.readString();
                aVar.E = parcel.readString();
                aVar.F = parcel.readString();
                aVar.G = parcel.readString();
                aVar.H = parcel.readString();
                aVar.I = parcel.readInt();
                return aVar;
            case 9:
                oc.f fVar = new oc.f();
                fVar.f9544y = "pronull";
                fVar.f9545z = 0;
                fVar.f9540u = parcel.readString();
                fVar.f9541v = parcel.readString();
                fVar.f9542w = parcel.readString();
                fVar.f9543x = parcel.readString();
                fVar.f9544y = parcel.readString();
                fVar.f9545z = parcel.readInt();
                fVar.A = parcel.readInt() == 1;
                return fVar;
            case 10:
                q4.s sVar = new q4.s();
                sVar.f10918u = parcel.readInt();
                sVar.f10919v = parcel.readInt();
                sVar.f10920w = parcel.readInt() == 1;
                return sVar;
            case 11:
                q4.c1 c1Var = new q4.c1();
                c1Var.f10756u = parcel.readInt();
                c1Var.f10757v = parcel.readInt();
                c1Var.f10759x = parcel.readInt() == 1;
                int i13 = parcel.readInt();
                if (i13 > 0) {
                    int[] iArr = new int[i13];
                    c1Var.f10758w = iArr;
                    parcel.readIntArray(iArr);
                }
                return c1Var;
            case 12:
                q4.d1 d1Var = new q4.d1();
                d1Var.f10765u = parcel.readInt();
                d1Var.f10766v = parcel.readInt();
                int i14 = parcel.readInt();
                d1Var.f10767w = i14;
                if (i14 > 0) {
                    int[] iArr2 = new int[i14];
                    d1Var.f10768x = iArr2;
                    parcel.readIntArray(iArr2);
                }
                int i15 = parcel.readInt();
                d1Var.f10769y = i15;
                if (i15 > 0) {
                    int[] iArr3 = new int[i15];
                    d1Var.f10770z = iArr3;
                    parcel.readIntArray(iArr3);
                }
                d1Var.B = parcel.readInt() == 1;
                d1Var.C = parcel.readInt() == 1;
                d1Var.D = parcel.readInt() == 1;
                d1Var.A = parcel.readArrayList(q4.c1.class.getClassLoader());
                return d1Var;
            case 13:
                int iV5 = q1.c.V(parcel);
                PendingIntent pendingIntent = null;
                int iJ6 = 0;
                int iJ7 = 0;
                String strU21 = null;
                while (parcel.dataPosition() < iV5) {
                    int i16 = parcel.readInt();
                    char c11 = (char) i16;
                    if (c11 == 1) {
                        iJ6 = q1.c.J(parcel, i16);
                    } else if (c11 == 2) {
                        iJ7 = q1.c.J(parcel, i16);
                    } else if (c11 == 3) {
                        pendingIntent = (PendingIntent) q1.c.t(parcel, i16, PendingIntent.CREATOR);
                    } else if (c11 != 4) {
                        q1.c.R(parcel, i16);
                    } else {
                        strU21 = q1.c.u(parcel, i16);
                    }
                }
                q1.c.z(parcel, iV5);
                return new q7.b(iJ6, iJ7, pendingIntent, strU21);
            case 14:
                int iV6 = q1.c.V(parcel);
                long jK12 = -1;
                int iJ8 = 0;
                String strU22 = null;
                while (parcel.dataPosition() < iV6) {
                    int i17 = parcel.readInt();
                    char c12 = (char) i17;
                    if (c12 == 1) {
                        strU22 = q1.c.u(parcel, i17);
                    } else if (c12 == 2) {
                        iJ8 = q1.c.J(parcel, i17);
                    } else if (c12 != 3) {
                        q1.c.R(parcel, i17);
                    } else {
                        jK12 = q1.c.K(parcel, i17);
                    }
                }
                q1.c.z(parcel, iV6);
                return new q7.d(iJ8, jK12, strU22);
            case 15:
                int iV7 = q1.c.V(parcel);
                boolean zI6 = false;
                int iJ9 = 0;
                String strU23 = null;
                int iJ10 = 0;
                while (parcel.dataPosition() < iV7) {
                    int i18 = parcel.readInt();
                    char c13 = (char) i18;
                    if (c13 == 1) {
                        zI6 = q1.c.I(parcel, i18);
                    } else if (c13 == 2) {
                        strU23 = q1.c.u(parcel, i18);
                    } else if (c13 == 3) {
                        iJ10 = q1.c.J(parcel, i18);
                    } else if (c13 != 4) {
                        q1.c.R(parcel, i18);
                    } else {
                        iJ9 = q1.c.J(parcel, i18);
                    }
                }
                q1.c.z(parcel, iV7);
                return new q7.r(iJ10, iJ9, strU23, zI6);
            case 16:
                int iV8 = q1.c.V(parcel);
                String strU24 = null;
                int iJ11 = 0;
                while (parcel.dataPosition() < iV8) {
                    int i19 = parcel.readInt();
                    char c14 = (char) i19;
                    if (c14 == 1) {
                        iJ11 = q1.c.J(parcel, i19);
                    } else if (c14 != 2) {
                        q1.c.R(parcel, i19);
                    } else {
                        strU24 = q1.c.u(parcel, i19);
                    }
                }
                q1.c.z(parcel, iV8);
                return new Scope(strU24, iJ11);
            case 17:
                int iV9 = q1.c.V(parcel);
                String strU25 = null;
                q7.b bVar = null;
                int iJ12 = 0;
                PendingIntent pendingIntent2 = null;
                while (parcel.dataPosition() < iV9) {
                    int i20 = parcel.readInt();
                    char c15 = (char) i20;
                    if (c15 == 1) {
                        iJ12 = q1.c.J(parcel, i20);
                    } else if (c15 == 2) {
                        strU25 = q1.c.u(parcel, i20);
                    } else if (c15 == 3) {
                        pendingIntent2 = (PendingIntent) q1.c.t(parcel, i20, PendingIntent.CREATOR);
                    } else if (c15 != 4) {
                        q1.c.R(parcel, i20);
                    } else {
                        bVar = (q7.b) q1.c.t(parcel, i20, q7.b.CREATOR);
                    }
                }
                q1.c.z(parcel, iV9);
                return new Status(iJ12, strU25, pendingIntent2, bVar);
            case 18:
                s8.b bVar2 = new s8.b();
                bVar2.C = 255;
                bVar2.E = -2;
                bVar2.F = -2;
                bVar2.G = -2;
                bVar2.N = Boolean.TRUE;
                bVar2.f11918u = parcel.readInt();
                bVar2.f11919v = (Integer) parcel.readSerializable();
                bVar2.f11920w = (Integer) parcel.readSerializable();
                bVar2.f11921x = (Integer) parcel.readSerializable();
                bVar2.f11922y = (Integer) parcel.readSerializable();
                bVar2.f11923z = (Integer) parcel.readSerializable();
                bVar2.A = (Integer) parcel.readSerializable();
                bVar2.B = (Integer) parcel.readSerializable();
                bVar2.C = parcel.readInt();
                bVar2.D = parcel.readString();
                bVar2.E = parcel.readInt();
                bVar2.F = parcel.readInt();
                bVar2.G = parcel.readInt();
                bVar2.I = parcel.readString();
                bVar2.J = parcel.readString();
                bVar2.K = parcel.readInt();
                bVar2.M = (Integer) parcel.readSerializable();
                bVar2.O = (Integer) parcel.readSerializable();
                bVar2.P = (Integer) parcel.readSerializable();
                bVar2.Q = (Integer) parcel.readSerializable();
                bVar2.R = (Integer) parcel.readSerializable();
                bVar2.S = (Integer) parcel.readSerializable();
                bVar2.T = (Integer) parcel.readSerializable();
                bVar2.W = (Integer) parcel.readSerializable();
                bVar2.U = (Integer) parcel.readSerializable();
                bVar2.V = (Integer) parcel.readSerializable();
                bVar2.N = (Boolean) parcel.readSerializable();
                bVar2.H = (Locale) parcel.readSerializable();
                bVar2.X = (Boolean) parcel.readSerializable();
                return bVar2;
            case 19:
                int iV10 = q1.c.V(parcel);
                int iJ13 = 0;
                while (true) {
                    ArrayList arrayListCreateTypedArrayList = null;
                    while (parcel.dataPosition() < iV10) {
                        int i21 = parcel.readInt();
                        char c16 = (char) i21;
                        if (c16 == 1) {
                            iJ13 = q1.c.J(parcel, i21);
                        } else if (c16 != 2) {
                            q1.c.R(parcel, i21);
                        } else {
                            Parcelable.Creator<t7.i> creator = t7.i.CREATOR;
                            int iL6 = q1.c.L(parcel, i21);
                            int iDataPosition2 = parcel.dataPosition();
                            if (iL6 == 0) {
                            }
                            arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
                            parcel.setDataPosition(iDataPosition2 + iL6);
                        }
                        break;
                    }
                    q1.c.z(parcel, iV10);
                    return new t7.l(iJ13, arrayListCreateTypedArrayList);
                }
                break;
            case 20:
                int iV11 = q1.c.V(parcel);
                int iJ14 = -1;
                int iJ15 = 0;
                int iJ16 = 0;
                int iJ17 = 0;
                int iJ18 = 0;
                String strU26 = null;
                String strU27 = null;
                long jK13 = 0;
                long jK14 = 0;
                while (parcel.dataPosition() < iV11) {
                    int i22 = parcel.readInt();
                    switch ((char) i22) {
                        case 1:
                            iJ15 = q1.c.J(parcel, i22);
                            break;
                        case 2:
                            iJ16 = q1.c.J(parcel, i22);
                            break;
                        case 3:
                            iJ17 = q1.c.J(parcel, i22);
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            jK13 = q1.c.K(parcel, i22);
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            jK14 = q1.c.K(parcel, i22);
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            strU26 = q1.c.u(parcel, i22);
                            break;
                        case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            strU27 = q1.c.u(parcel, i22);
                            break;
                        case '\b':
                            iJ18 = q1.c.J(parcel, i22);
                            break;
                        case '\t':
                            iJ14 = q1.c.J(parcel, i22);
                            break;
                        default:
                            q1.c.R(parcel, i22);
                            break;
                    }
                }
                q1.c.z(parcel, iV11);
                return new t7.i(iJ15, iJ16, iJ17, jK13, jK14, strU26, strU27, iJ18, iJ14);
            case 21:
                int iV12 = q1.c.V(parcel);
                int iJ19 = 0;
                int iJ20 = 0;
                int iJ21 = 0;
                boolean zI7 = false;
                boolean zI8 = false;
                while (parcel.dataPosition() < iV12) {
                    int i23 = parcel.readInt();
                    char c17 = (char) i23;
                    if (c17 == 1) {
                        iJ19 = q1.c.J(parcel, i23);
                    } else if (c17 == 2) {
                        zI7 = q1.c.I(parcel, i23);
                    } else if (c17 == 3) {
                        zI8 = q1.c.I(parcel, i23);
                    } else if (c17 == 4) {
                        iJ20 = q1.c.J(parcel, i23);
                    } else if (c17 != 5) {
                        q1.c.R(parcel, i23);
                    } else {
                        iJ21 = q1.c.J(parcel, i23);
                    }
                }
                q1.c.z(parcel, iV12);
                return new t7.k(iJ19, iJ20, iJ21, zI7, zI8);
            case 22:
                int iV13 = q1.c.V(parcel);
                Bundle bundleS = null;
                t7.f fVar2 = null;
                int iJ22 = 0;
                q7.d[] dVarArr = null;
                while (parcel.dataPosition() < iV13) {
                    int i24 = parcel.readInt();
                    char c18 = (char) i24;
                    if (c18 == 1) {
                        bundleS = q1.c.s(parcel, i24);
                    } else if (c18 == 2) {
                        dVarArr = (q7.d[]) q1.c.v(parcel, i24, q7.d.CREATOR);
                    } else if (c18 == 3) {
                        iJ22 = q1.c.J(parcel, i24);
                    } else if (c18 != 4) {
                        q1.c.R(parcel, i24);
                    } else {
                        fVar2 = (t7.f) q1.c.t(parcel, i24, t7.f.CREATOR);
                    }
                }
                q1.c.z(parcel, iV13);
                t7.b0 b0Var = new t7.b0();
                b0Var.f12251u = bundleS;
                b0Var.f12252v = dVarArr;
                b0Var.f12253w = iJ22;
                b0Var.f12254x = fVar2;
                return b0Var;
            case 23:
                int iV14 = q1.c.V(parcel);
                t7.k kVar = null;
                int[] iArrCreateIntArray = null;
                int[] iArrCreateIntArray2 = null;
                boolean zI9 = false;
                boolean zI10 = false;
                int iJ23 = 0;
                while (parcel.dataPosition() < iV14) {
                    int i25 = parcel.readInt();
                    switch ((char) i25) {
                        case 1:
                            kVar = (t7.k) q1.c.t(parcel, i25, t7.k.CREATOR);
                            break;
                        case 2:
                            zI9 = q1.c.I(parcel, i25);
                            break;
                        case 3:
                            zI10 = q1.c.I(parcel, i25);
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            int iL7 = q1.c.L(parcel, i25);
                            int iDataPosition3 = parcel.dataPosition();
                            if (iL7 != 0) {
                                iArrCreateIntArray = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition3 + iL7);
                            } else {
                                iArrCreateIntArray = null;
                            }
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            iJ23 = q1.c.J(parcel, i25);
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            int iL8 = q1.c.L(parcel, i25);
                            int iDataPosition4 = parcel.dataPosition();
                            if (iL8 != 0) {
                                iArrCreateIntArray2 = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition4 + iL8);
                            } else {
                                iArrCreateIntArray2 = null;
                            }
                            break;
                        default:
                            q1.c.R(parcel, i25);
                            break;
                    }
                }
                q1.c.z(parcel, iV14);
                return new t7.f(kVar, zI9, zI10, iArrCreateIntArray, iJ23, iArrCreateIntArray2);
            case 24:
                int iV15 = q1.c.V(parcel);
                Bundle bundle = new Bundle();
                Scope[] scopeArr = t7.g.I;
                String strU28 = null;
                IBinder iBinder = null;
                Account account = null;
                String strU29 = null;
                int iJ24 = 0;
                int iJ25 = 0;
                int iJ26 = 0;
                boolean zI11 = false;
                int iJ27 = 0;
                boolean zI12 = false;
                q7.d[] dVarArr2 = t7.g.J;
                q7.d[] dVarArr3 = dVarArr2;
                while (parcel.dataPosition() < iV15) {
                    int i26 = parcel.readInt();
                    switch ((char) i26) {
                        case 1:
                            iJ24 = q1.c.J(parcel, i26);
                            break;
                        case 2:
                            iJ25 = q1.c.J(parcel, i26);
                            break;
                        case 3:
                            iJ26 = q1.c.J(parcel, i26);
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            strU28 = q1.c.u(parcel, i26);
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            int iL9 = q1.c.L(parcel, i26);
                            int iDataPosition5 = parcel.dataPosition();
                            if (iL9 != 0) {
                                IBinder strongBinder = parcel.readStrongBinder();
                                parcel.setDataPosition(iDataPosition5 + iL9);
                                iBinder = strongBinder;
                            } else {
                                iBinder = null;
                            }
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            scopeArr = (Scope[]) q1.c.v(parcel, i26, Scope.CREATOR);
                            break;
                        case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            bundle = q1.c.s(parcel, i26);
                            break;
                        case '\b':
                            account = (Account) q1.c.t(parcel, i26, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            q1.c.R(parcel, i26);
                            break;
                        case '\n':
                            dVarArr2 = (q7.d[]) q1.c.v(parcel, i26, q7.d.CREATOR);
                            break;
                        case 11:
                            dVarArr3 = (q7.d[]) q1.c.v(parcel, i26, q7.d.CREATOR);
                            break;
                        case '\f':
                            zI11 = q1.c.I(parcel, i26);
                            break;
                        case '\r':
                            iJ27 = q1.c.J(parcel, i26);
                            break;
                        case 14:
                            zI12 = q1.c.I(parcel, i26);
                            break;
                        case 15:
                            strU29 = q1.c.u(parcel, i26);
                            break;
                    }
                }
                q1.c.z(parcel, iV15);
                return new t7.g(iJ24, iJ25, iJ26, strU28, iBinder, scopeArr, bundle, account, dVarArr2, dVarArr3, zI11, iJ27, zI12, strU29);
            case 25:
                u0.g gVar2 = new u0.g(parcel);
                gVar2.f12537u = parcel.readInt();
                return gVar2;
            default:
                int iV16 = q1.c.V(parcel);
                Bundle bundleS2 = null;
                while (parcel.dataPosition() < iV16) {
                    int i27 = parcel.readInt();
                    if (((char) i27) != 2) {
                        q1.c.R(parcel, i27);
                    } else {
                        bundleS2 = q1.c.s(parcel, i27);
                    }
                }
                q1.c.z(parcel, iV16);
                return new ub.n(bundleS2);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f7533a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new v[i];
            case 1:
                return new r3[i];
            case 2:
                return new e4[i];
            case 3:
                return new a4[i];
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return new l5.g[i];
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return new l9.h[i];
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return new n.j[i];
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return new n.o0[i];
            case 8:
                return new oc.a[i];
            case 9:
                return new oc.f[i];
            case 10:
                return new q4.s[i];
            case 11:
                return new q4.c1[i];
            case 12:
                return new q4.d1[i];
            case 13:
                return new q7.b[i];
            case 14:
                return new q7.d[i];
            case 15:
                return new q7.r[i];
            case 16:
                return new Scope[i];
            case 17:
                return new Status[i];
            case 18:
                return new s8.b[i];
            case 19:
                return new t7.l[i];
            case 20:
                return new t7.i[i];
            case 21:
                return new t7.k[i];
            case 22:
                return new t7.b0[i];
            case 23:
                return new t7.f[i];
            case 24:
                return new t7.g[i];
            case 25:
                return new u0.g[i];
            default:
                return new ub.n[i];
        }
    }
}
