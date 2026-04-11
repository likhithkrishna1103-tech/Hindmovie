package android.support.v4.media;

import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.n0;
import androidx.fragment.app.s0;
import androidx.fragment.app.x0;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.navigation.g;
import b.d;
import com.google.android.material.datepicker.r;
import f9.e;
import f9.f4;
import f9.i4;
import f9.j4;
import f9.k4;
import f9.s4;
import f9.u;
import f9.v;
import f9.w4;
import g1.h;
import g6.f;
import ge.i;
import j5.j;
import java.util.ArrayList;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f486a;

    public /* synthetic */ a(int i) {
        this.f486a = i;
    }

    public static void a(v vVar, Parcel parcel, int i) {
        String str = vVar.f4441v;
        int iW = t1.w(parcel, 20293);
        t1.r(parcel, 2, str);
        t1.q(parcel, 3, vVar.f4442w, i);
        t1.r(parcel, 4, vVar.f4443x);
        long j4 = vVar.f4444y;
        t1.v(parcel, 5, 8);
        parcel.writeLong(j4);
        t1.y(parcel, iW);
    }

    public static void b(s4 s4Var, Parcel parcel) {
        int i = s4Var.f4403v;
        int iW = t1.w(parcel, 20293);
        t1.v(parcel, 1, 4);
        parcel.writeInt(i);
        t1.r(parcel, 2, s4Var.f4404w);
        long j4 = s4Var.f4405x;
        t1.v(parcel, 3, 8);
        parcel.writeLong(j4);
        Long l10 = s4Var.f4406y;
        if (l10 != null) {
            t1.v(parcel, 4, 8);
            parcel.writeLong(l10.longValue());
        }
        t1.r(parcel, 6, s4Var.f4407z);
        t1.r(parcel, 7, s4Var.A);
        Double d10 = s4Var.B;
        if (d10 != null) {
            t1.v(parcel, 8, 8);
            parcel.writeDouble(d10.doubleValue());
        }
        t1.y(parcel, iW);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        Bundle bundle;
        long jG = 0;
        int iF = 0;
        b.b bVar = null;
        ArrayList arrayListL = null;
        String strJ = null;
        Bundle bundleG = null;
        Bundle bundleG2 = null;
        switch (this.f486a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new Parcelable(parcel) { // from class: android.support.v4.media.MediaBrowserCompat$MediaItem
                    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new a(0);

                    /* JADX INFO: renamed from: v, reason: collision with root package name */
                    public final int f476v;

                    /* JADX INFO: renamed from: w, reason: collision with root package name */
                    public final MediaDescriptionCompat f477w;

                    {
                        this.f476v = parcel.readInt();
                        this.f477w = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        return "MediaItem{mFlags=" + this.f476v + ", mDescription=" + this.f477w + '}';
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i) {
                        parcel2.writeInt(this.f476v);
                        this.f477w.writeToParcel(parcel2, i);
                    }
                };
            case 1:
                Object objCreateFromParcel = MediaDescription.CREATOR.createFromParcel(parcel);
                if (objCreateFromParcel == null) {
                    return null;
                }
                MediaDescription mediaDescription = (MediaDescription) objCreateFromParcel;
                String strG = b.g(mediaDescription);
                CharSequence charSequenceI = b.i(mediaDescription);
                CharSequence charSequenceH = b.h(mediaDescription);
                CharSequence charSequenceC = b.c(mediaDescription);
                Bitmap bitmapE = b.e(mediaDescription);
                Uri uriF = b.f(mediaDescription);
                Bundle bundleD = b.d(mediaDescription);
                if (bundleD != null) {
                    bundleD = android.support.v4.media.session.b.Q(bundleD);
                }
                Uri uriA = bundleD != null ? (Uri) bundleD.getParcelable("android.support.v4.media.description.MEDIA_URI") : null;
                if (uriA == null) {
                    bundle = bundleD;
                } else if (bundleD.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && bundleD.size() == 2) {
                    bundle = null;
                } else {
                    bundleD.remove("android.support.v4.media.description.MEDIA_URI");
                    bundleD.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                    bundle = bundleD;
                }
                if (uriA == null) {
                    uriA = c.a(mediaDescription);
                }
                MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(strG, charSequenceI, charSequenceH, charSequenceC, bitmapE, uriF, bundle, uriA);
                mediaDescriptionCompat.D = mediaDescription;
                return mediaDescriptionCompat;
            case 2:
                return new MediaMetadataCompat(parcel);
            case 3:
                return new RatingCompat(parcel.readInt(), parcel.readFloat());
            case h.LONG_FIELD_NUMBER /* 4 */:
                return new androidx.fragment.app.b(parcel);
            case h.STRING_FIELD_NUMBER /* 5 */:
                return new androidx.fragment.app.c(parcel);
            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                n0 n0Var = new n0();
                n0Var.f1024v = parcel.readString();
                n0Var.f1025w = parcel.readInt();
                return n0Var;
            case h.DOUBLE_FIELD_NUMBER /* 7 */:
                s0 s0Var = new s0();
                s0Var.f1073z = null;
                s0Var.A = new ArrayList();
                s0Var.B = new ArrayList();
                s0Var.f1069v = parcel.createStringArrayList();
                s0Var.f1070w = parcel.createStringArrayList();
                s0Var.f1071x = (androidx.fragment.app.b[]) parcel.createTypedArray(androidx.fragment.app.b.CREATOR);
                s0Var.f1072y = parcel.readInt();
                s0Var.f1073z = parcel.readString();
                s0Var.A = parcel.createStringArrayList();
                s0Var.B = parcel.createTypedArrayList(androidx.fragment.app.c.CREATOR);
                s0Var.C = parcel.createTypedArrayList(n0.CREATOR);
                return s0Var;
            case h.BYTES_FIELD_NUMBER /* 8 */:
                return new x0(parcel);
            case 9:
                return new g(parcel);
            case 10:
                d dVar = new d();
                IBinder strongBinder = parcel.readStrongBinder();
                int i = b.c.f1582e;
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(b.b.f1581a);
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b.b)) {
                        b.a aVar = new b.a();
                        aVar.f1580d = strongBinder;
                        bVar = aVar;
                    } else {
                        bVar = (b.b) iInterfaceQueryLocalInterface;
                    }
                }
                dVar.f1584v = bVar;
                return dVar;
            case 11:
                return new com.google.android.material.datepicker.b((r) parcel.readParcelable(r.class.getClassLoader()), (r) parcel.readParcelable(r.class.getClassLoader()), (com.google.android.material.datepicker.d) parcel.readParcelable(com.google.android.material.datepicker.d.class.getClassLoader()), (r) parcel.readParcelable(r.class.getClassLoader()), parcel.readInt());
            case 12:
                return new com.google.android.material.datepicker.d(parcel.readLong());
            case 13:
                return r.a(parcel.readInt(), parcel.readInt());
            case 14:
                i.e(parcel, "parcel");
                return new e.a(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
            case 15:
                i.e(parcel, "inParcel");
                Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
                i.b(parcelable);
                return new e.h((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case 16:
                int iO = n5.a.O(parcel);
                long jG2 = 0;
                long jG3 = 0;
                int iF2 = 0;
                while (parcel.dataPosition() < iO) {
                    int i10 = parcel.readInt();
                    char c9 = (char) i10;
                    if (c9 == 1) {
                        jG2 = n5.a.G(parcel, i10);
                    } else if (c9 == 2) {
                        iF2 = n5.a.F(parcel, i10);
                    } else if (c9 != 3) {
                        n5.a.K(parcel, i10);
                    } else {
                        jG3 = n5.a.G(parcel, i10);
                    }
                }
                n5.a.m(parcel, iO);
                return new f9.d(iF2, jG2, jG3);
            case 17:
                int iO2 = n5.a.O(parcel);
                long jG4 = 0;
                long jG5 = 0;
                long jG6 = 0;
                boolean zE = false;
                String strJ2 = null;
                String strJ3 = null;
                s4 s4Var = null;
                String strJ4 = null;
                v vVar = null;
                v vVar2 = null;
                v vVar3 = null;
                while (parcel.dataPosition() < iO2) {
                    int i11 = parcel.readInt();
                    switch ((char) i11) {
                        case 2:
                            strJ2 = n5.a.j(parcel, i11);
                            break;
                        case 3:
                            strJ3 = n5.a.j(parcel, i11);
                            break;
                        case h.LONG_FIELD_NUMBER /* 4 */:
                            s4Var = (s4) n5.a.i(parcel, i11, s4.CREATOR);
                            break;
                        case h.STRING_FIELD_NUMBER /* 5 */:
                            jG4 = n5.a.G(parcel, i11);
                            break;
                        case h.STRING_SET_FIELD_NUMBER /* 6 */:
                            zE = n5.a.E(parcel, i11);
                            break;
                        case h.DOUBLE_FIELD_NUMBER /* 7 */:
                            strJ4 = n5.a.j(parcel, i11);
                            break;
                        case h.BYTES_FIELD_NUMBER /* 8 */:
                            vVar = (v) n5.a.i(parcel, i11, v.CREATOR);
                            break;
                        case '\t':
                            jG5 = n5.a.G(parcel, i11);
                            break;
                        case '\n':
                            vVar2 = (v) n5.a.i(parcel, i11, v.CREATOR);
                            break;
                        case 11:
                            jG6 = n5.a.G(parcel, i11);
                            break;
                        case '\f':
                            vVar3 = (v) n5.a.i(parcel, i11, v.CREATOR);
                            break;
                        default:
                            n5.a.K(parcel, i11);
                            break;
                    }
                }
                n5.a.m(parcel, iO2);
                return new e(strJ2, strJ3, s4Var, jG4, zE, strJ4, vVar, jG5, vVar2, jG6, vVar3);
            case 18:
                int iO3 = n5.a.O(parcel);
                while (parcel.dataPosition() < iO3) {
                    int i12 = parcel.readInt();
                    if (((char) i12) != 1) {
                        n5.a.K(parcel, i12);
                    } else {
                        bundleG2 = n5.a.g(parcel, i12);
                    }
                }
                n5.a.m(parcel, iO3);
                return new f9.i(bundleG2);
            case 19:
                int iO4 = n5.a.O(parcel);
                while (parcel.dataPosition() < iO4) {
                    int i13 = parcel.readInt();
                    if (((char) i13) != 2) {
                        n5.a.K(parcel, i13);
                    } else {
                        bundleG = n5.a.g(parcel, i13);
                    }
                }
                n5.a.m(parcel, iO4);
                return new u(bundleG);
            case 20:
                int iO5 = n5.a.O(parcel);
                long jG7 = 0;
                String strJ5 = null;
                u uVar = null;
                String strJ6 = null;
                while (parcel.dataPosition() < iO5) {
                    int i14 = parcel.readInt();
                    char c10 = (char) i14;
                    if (c10 == 2) {
                        strJ5 = n5.a.j(parcel, i14);
                    } else if (c10 == 3) {
                        uVar = (u) n5.a.i(parcel, i14, u.CREATOR);
                    } else if (c10 == 4) {
                        strJ6 = n5.a.j(parcel, i14);
                    } else if (c10 != 5) {
                        n5.a.K(parcel, i14);
                    } else {
                        jG7 = n5.a.G(parcel, i14);
                    }
                }
                n5.a.m(parcel, iO5);
                return new v(strJ5, uVar, strJ6, jG7);
            case 21:
                int iO6 = n5.a.O(parcel);
                while (parcel.dataPosition() < iO6) {
                    int i15 = parcel.readInt();
                    char c11 = (char) i15;
                    if (c11 == 1) {
                        strJ = n5.a.j(parcel, i15);
                    } else if (c11 == 2) {
                        jG = n5.a.G(parcel, i15);
                    } else if (c11 != 3) {
                        n5.a.K(parcel, i15);
                    } else {
                        iF = n5.a.F(parcel, i15);
                    }
                }
                n5.a.m(parcel, iO6);
                return new f4(iF, jG, strJ);
            case 22:
                int iO7 = n5.a.O(parcel);
                long jG8 = 0;
                long jG9 = 0;
                int iF3 = 0;
                byte[] bArr = null;
                String strJ7 = null;
                Bundle bundleG3 = null;
                String strJ8 = null;
                while (parcel.dataPosition() < iO7) {
                    int i16 = parcel.readInt();
                    switch ((char) i16) {
                        case 1:
                            jG8 = n5.a.G(parcel, i16);
                            break;
                        case 2:
                            int iH = n5.a.H(parcel, i16);
                            int iDataPosition = parcel.dataPosition();
                            if (iH == 0) {
                                bArr = null;
                            } else {
                                byte[] bArrCreateByteArray = parcel.createByteArray();
                                parcel.setDataPosition(iDataPosition + iH);
                                bArr = bArrCreateByteArray;
                            }
                            break;
                        case 3:
                            strJ7 = n5.a.j(parcel, i16);
                            break;
                        case h.LONG_FIELD_NUMBER /* 4 */:
                            bundleG3 = n5.a.g(parcel, i16);
                            break;
                        case h.STRING_FIELD_NUMBER /* 5 */:
                            iF3 = n5.a.F(parcel, i16);
                            break;
                        case h.STRING_SET_FIELD_NUMBER /* 6 */:
                            jG9 = n5.a.G(parcel, i16);
                            break;
                        case h.DOUBLE_FIELD_NUMBER /* 7 */:
                            strJ8 = n5.a.j(parcel, i16);
                            break;
                        default:
                            n5.a.K(parcel, i16);
                            break;
                    }
                }
                n5.a.m(parcel, iO7);
                return new i4(jG8, bArr, strJ7, bundleG3, iF3, jG9, strJ8);
            case 23:
                int iO8 = n5.a.O(parcel);
                while (true) {
                    ArrayList arrayList = null;
                    while (parcel.dataPosition() < iO8) {
                        int i17 = parcel.readInt();
                        if (((char) i17) != 1) {
                            n5.a.K(parcel, i17);
                        } else {
                            int iH2 = n5.a.H(parcel, i17);
                            int iDataPosition2 = parcel.dataPosition();
                            if (iH2 == 0) {
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int i18 = parcel.readInt();
                            for (int i19 = 0; i19 < i18; i19++) {
                                arrayList2.add(Integer.valueOf(parcel.readInt()));
                            }
                            parcel.setDataPosition(iDataPosition2 + iH2);
                            arrayList = arrayList2;
                        }
                        break;
                    }
                    n5.a.m(parcel, iO8);
                    return new j4(arrayList);
                }
                break;
            case 24:
                int iO9 = n5.a.O(parcel);
                while (parcel.dataPosition() < iO9) {
                    int i20 = parcel.readInt();
                    if (((char) i20) != 1) {
                        n5.a.K(parcel, i20);
                    } else {
                        arrayListL = n5.a.l(parcel, i20, i4.CREATOR);
                    }
                }
                n5.a.m(parcel, iO9);
                return new k4(arrayListL);
            case 25:
                int iO10 = n5.a.O(parcel);
                long jG10 = 0;
                int iF4 = 0;
                String strJ9 = null;
                Long lValueOf = null;
                Float fValueOf = null;
                String strJ10 = null;
                String strJ11 = null;
                Double dValueOf = null;
                while (parcel.dataPosition() < iO10) {
                    int i21 = parcel.readInt();
                    switch ((char) i21) {
                        case 1:
                            iF4 = n5.a.F(parcel, i21);
                            break;
                        case 2:
                            strJ9 = n5.a.j(parcel, i21);
                            break;
                        case 3:
                            jG10 = n5.a.G(parcel, i21);
                            break;
                        case h.LONG_FIELD_NUMBER /* 4 */:
                            int iH3 = n5.a.H(parcel, i21);
                            if (iH3 == 0) {
                                lValueOf = null;
                            } else {
                                n5.a.S(parcel, iH3, 8);
                                lValueOf = Long.valueOf(parcel.readLong());
                            }
                            break;
                        case h.STRING_FIELD_NUMBER /* 5 */:
                            int iH4 = n5.a.H(parcel, i21);
                            if (iH4 == 0) {
                                fValueOf = null;
                            } else {
                                n5.a.S(parcel, iH4, 4);
                                fValueOf = Float.valueOf(parcel.readFloat());
                            }
                            break;
                        case h.STRING_SET_FIELD_NUMBER /* 6 */:
                            strJ10 = n5.a.j(parcel, i21);
                            break;
                        case h.DOUBLE_FIELD_NUMBER /* 7 */:
                            strJ11 = n5.a.j(parcel, i21);
                            break;
                        case h.BYTES_FIELD_NUMBER /* 8 */:
                            int iH5 = n5.a.H(parcel, i21);
                            if (iH5 == 0) {
                                dValueOf = null;
                            } else {
                                n5.a.S(parcel, iH5, 8);
                                dValueOf = Double.valueOf(parcel.readDouble());
                            }
                            break;
                        default:
                            n5.a.K(parcel, i21);
                            break;
                    }
                }
                n5.a.m(parcel, iO10);
                return new s4(iF4, strJ9, jG10, lValueOf, fValueOf, strJ10, strJ11, dValueOf);
            case 26:
                int iO11 = n5.a.O(parcel);
                String strJ12 = "";
                String strJ13 = strJ12;
                String strJ14 = strJ13;
                String strJ15 = strJ14;
                int iF5 = 100;
                long jG11 = 0;
                long jG12 = 0;
                long jG13 = 0;
                long jG14 = 0;
                long jG15 = 0;
                long jG16 = 0;
                long jG17 = 0;
                boolean zE2 = true;
                boolean zE3 = true;
                boolean zE4 = false;
                int iF6 = 0;
                boolean zE5 = false;
                boolean zE6 = false;
                int iF7 = 0;
                int iF8 = 0;
                String strJ16 = null;
                String strJ17 = null;
                String strJ18 = null;
                String strJ19 = null;
                String strJ20 = null;
                String strJ21 = null;
                Boolean boolValueOf = null;
                ArrayList<String> arrayList3 = null;
                String strJ22 = null;
                String strJ23 = null;
                long jG18 = -2147483648L;
                while (parcel.dataPosition() < iO11) {
                    int i22 = parcel.readInt();
                    switch ((char) i22) {
                        case 2:
                            strJ16 = n5.a.j(parcel, i22);
                            break;
                        case 3:
                            strJ17 = n5.a.j(parcel, i22);
                            break;
                        case h.LONG_FIELD_NUMBER /* 4 */:
                            strJ18 = n5.a.j(parcel, i22);
                            break;
                        case h.STRING_FIELD_NUMBER /* 5 */:
                            strJ19 = n5.a.j(parcel, i22);
                            break;
                        case h.STRING_SET_FIELD_NUMBER /* 6 */:
                            jG11 = n5.a.G(parcel, i22);
                            break;
                        case h.DOUBLE_FIELD_NUMBER /* 7 */:
                            jG12 = n5.a.G(parcel, i22);
                            break;
                        case h.BYTES_FIELD_NUMBER /* 8 */:
                            strJ20 = n5.a.j(parcel, i22);
                            break;
                        case '\t':
                            zE2 = n5.a.E(parcel, i22);
                            break;
                        case '\n':
                            zE4 = n5.a.E(parcel, i22);
                            break;
                        case 11:
                            jG18 = n5.a.G(parcel, i22);
                            break;
                        case '\f':
                            strJ21 = n5.a.j(parcel, i22);
                            break;
                        case '\r':
                        case 17:
                        case 19:
                        case 20:
                        case 24:
                        case '!':
                        default:
                            n5.a.K(parcel, i22);
                            break;
                        case 14:
                            jG13 = n5.a.G(parcel, i22);
                            break;
                        case 15:
                            iF6 = n5.a.F(parcel, i22);
                            break;
                        case 16:
                            zE3 = n5.a.E(parcel, i22);
                            break;
                        case 18:
                            zE5 = n5.a.E(parcel, i22);
                            break;
                        case 21:
                            int iH6 = n5.a.H(parcel, i22);
                            if (iH6 == 0) {
                                boolValueOf = null;
                            } else {
                                n5.a.S(parcel, iH6, 4);
                                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
                            }
                            break;
                        case 22:
                            jG14 = n5.a.G(parcel, i22);
                            break;
                        case 23:
                            int iH7 = n5.a.H(parcel, i22);
                            int iDataPosition3 = parcel.dataPosition();
                            if (iH7 == 0) {
                                arrayList3 = null;
                            } else {
                                ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                                parcel.setDataPosition(iDataPosition3 + iH7);
                                arrayList3 = arrayListCreateStringArrayList;
                            }
                            break;
                        case 25:
                            strJ12 = n5.a.j(parcel, i22);
                            break;
                        case 26:
                            strJ13 = n5.a.j(parcel, i22);
                            break;
                        case 27:
                            strJ22 = n5.a.j(parcel, i22);
                            break;
                        case 28:
                            zE6 = n5.a.E(parcel, i22);
                            break;
                        case 29:
                            jG15 = n5.a.G(parcel, i22);
                            break;
                        case 30:
                            iF5 = n5.a.F(parcel, i22);
                            break;
                        case 31:
                            strJ14 = n5.a.j(parcel, i22);
                            break;
                        case ' ':
                            iF7 = n5.a.F(parcel, i22);
                            break;
                        case '\"':
                            jG16 = n5.a.G(parcel, i22);
                            break;
                        case '#':
                            strJ23 = n5.a.j(parcel, i22);
                            break;
                        case '$':
                            strJ15 = n5.a.j(parcel, i22);
                            break;
                        case '%':
                            jG17 = n5.a.G(parcel, i22);
                            break;
                        case '&':
                            iF8 = n5.a.F(parcel, i22);
                            break;
                    }
                }
                n5.a.m(parcel, iO11);
                return new w4(strJ16, strJ17, strJ18, strJ19, jG11, jG12, strJ20, zE2, zE4, jG18, strJ21, jG13, iF6, zE3, zE5, boolValueOf, jG14, arrayList3, strJ12, strJ13, strJ22, zE6, jG15, iF5, strJ14, iF7, jG16, strJ23, strJ15, jG17, iF8);
            case 27:
                f fVar = new f(parcel);
                fVar.f5070v = parcel.readString();
                fVar.f5072x = parcel.readFloat();
                fVar.f5073y = parcel.readInt() == 1;
                fVar.f5074z = parcel.readString();
                fVar.A = parcel.readInt();
                fVar.B = parcel.readInt();
                return fVar;
            default:
                return new j(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f486a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new MediaBrowserCompat$MediaItem[i];
            case 1:
                return new MediaDescriptionCompat[i];
            case 2:
                return new MediaMetadataCompat[i];
            case 3:
                return new RatingCompat[i];
            case h.LONG_FIELD_NUMBER /* 4 */:
                return new androidx.fragment.app.b[i];
            case h.STRING_FIELD_NUMBER /* 5 */:
                return new androidx.fragment.app.c[i];
            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                return new n0[i];
            case h.DOUBLE_FIELD_NUMBER /* 7 */:
                return new s0[i];
            case h.BYTES_FIELD_NUMBER /* 8 */:
                return new x0[i];
            case 9:
                return new g[i];
            case 10:
                return new d[i];
            case 11:
                return new com.google.android.material.datepicker.b[i];
            case 12:
                return new com.google.android.material.datepicker.d[i];
            case 13:
                return new r[i];
            case 14:
                return new e.a[i];
            case 15:
                return new e.h[i];
            case 16:
                return new f9.d[i];
            case 17:
                return new e[i];
            case 18:
                return new f9.i[i];
            case 19:
                return new u[i];
            case 20:
                return new v[i];
            case 21:
                return new f4[i];
            case 22:
                return new i4[i];
            case 23:
                return new j4[i];
            case 24:
                return new k4[i];
            case 25:
                return new s4[i];
            case 26:
                return new w4[i];
            case 27:
                return new f[i];
            default:
                return new j[i];
        }
    }
}
