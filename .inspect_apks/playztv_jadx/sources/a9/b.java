package a9;

import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.util.Log;
import androidx.fragment.app.k0;
import androidx.fragment.app.o0;
import androidx.fragment.app.s0;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.versionedparcelable.ParcelImpl;
import b1.j;
import be.h;
import com.google.android.material.datepicker.q;
import e5.k;
import h4.f0;
import h4.g0;
import h4.h0;
import h4.i0;
import h4.n;
import h4.o;
import h4.w;
import h4.x;
import h4.y;
import h4.z;
import java.util.ArrayList;
import k8.e4;
import k8.g;
import k8.u;
import k8.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f633a;

    public /* synthetic */ b(int i) {
        this.f633a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        Bundle bundle;
        Bundle bundle2;
        b.b bVar = null;
        Bundle bundleS = null;
        Bundle bundleS2 = null;
        Uri mediaUri = null;
        switch (this.f633a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c cVar = new c(parcel);
                cVar.f634u = ((Integer) parcel.readValue(c.class.getClassLoader())).intValue();
                return cVar;
            case 1:
                return new Parcelable(parcel) { // from class: android.support.v4.media.MediaBrowserCompat$MediaItem
                    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new a9.b(1);

                    /* JADX INFO: renamed from: u, reason: collision with root package name */
                    public final int f819u;

                    /* JADX INFO: renamed from: v, reason: collision with root package name */
                    public final MediaDescriptionCompat f820v;

                    {
                        this.f819u = parcel.readInt();
                        this.f820v = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        return "MediaItem{mFlags=" + this.f819u + ", mDescription=" + this.f820v + '}';
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i) {
                        parcel2.writeInt(this.f819u);
                        this.f820v.writeToParcel(parcel2, i);
                    }
                };
            case 2:
                Object objCreateFromParcel = MediaDescription.CREATOR.createFromParcel(parcel);
                if (objCreateFromParcel == null) {
                    return null;
                }
                MediaDescription mediaDescription = (MediaDescription) objCreateFromParcel;
                String strG = android.support.v4.media.a.g(mediaDescription);
                CharSequence charSequenceI = android.support.v4.media.a.i(mediaDescription);
                CharSequence charSequenceH = android.support.v4.media.a.h(mediaDescription);
                CharSequence charSequenceC = android.support.v4.media.a.c(mediaDescription);
                Bitmap bitmapE = android.support.v4.media.a.e(mediaDescription);
                Uri uriF = android.support.v4.media.a.f(mediaDescription);
                Bundle bundleD = android.support.v4.media.a.d(mediaDescription);
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
                    uriA = android.support.v4.media.b.a(mediaDescription);
                }
                MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(strG, charSequenceI, charSequenceH, charSequenceC, bitmapE, uriF, bundle, uriA);
                mediaDescriptionCompat.C = mediaDescription;
                return mediaDescriptionCompat;
            case 3:
                return new MediaMetadataCompat(parcel);
            case j.LONG_FIELD_NUMBER /* 4 */:
                return new RatingCompat(parcel.readInt(), parcel.readFloat());
            case j.STRING_FIELD_NUMBER /* 5 */:
                return new androidx.fragment.app.b(parcel);
            case j.STRING_SET_FIELD_NUMBER /* 6 */:
                return new androidx.fragment.app.c(parcel);
            case j.DOUBLE_FIELD_NUMBER /* 7 */:
                k0 k0Var = new k0();
                k0Var.f1294u = parcel.readString();
                k0Var.f1295v = parcel.readInt();
                return k0Var;
            case 8:
                o0 o0Var = new o0();
                o0Var.f1339y = null;
                o0Var.f1340z = new ArrayList();
                o0Var.A = new ArrayList();
                o0Var.f1335u = parcel.createStringArrayList();
                o0Var.f1336v = parcel.createStringArrayList();
                o0Var.f1337w = (androidx.fragment.app.b[]) parcel.createTypedArray(androidx.fragment.app.b.CREATOR);
                o0Var.f1338x = parcel.readInt();
                o0Var.f1339y = parcel.readString();
                o0Var.f1340z = parcel.createStringArrayList();
                o0Var.A = parcel.createTypedArrayList(androidx.fragment.app.c.CREATOR);
                o0Var.B = parcel.createTypedArrayList(k0.CREATOR);
                return o0Var;
            case 9:
                return new s0(parcel);
            case 10:
                b.d dVar = new b.d();
                IBinder strongBinder = parcel.readStrongBinder();
                int i = b.c.f1707e;
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(b.b.f1706a);
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b.b)) {
                        b.a aVar = new b.a();
                        aVar.f1705d = strongBinder;
                        bVar = aVar;
                    } else {
                        bVar = (b.b) iInterfaceQueryLocalInterface;
                    }
                }
                dVar.f1709u = bVar;
                return dVar;
            case 11:
                return new com.google.android.material.datepicker.b((q) parcel.readParcelable(q.class.getClassLoader()), (q) parcel.readParcelable(q.class.getClassLoader()), (com.google.android.material.datepicker.d) parcel.readParcelable(com.google.android.material.datepicker.d.class.getClassLoader()), (q) parcel.readParcelable(q.class.getClassLoader()), parcel.readInt());
            case 12:
                return new com.google.android.material.datepicker.d(parcel.readLong());
            case 13:
                return q.a(parcel.readInt(), parcel.readInt());
            case 14:
                h.e(parcel, "parcel");
                return new e.a(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
            case 15:
                h.e(parcel, "inParcel");
                Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
                h.b(parcelable);
                return new e.h((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case 16:
                return new k(parcel);
            case 17:
                MediaDescription mediaDescription2 = (MediaDescription) MediaDescription.CREATOR.createFromParcel(parcel);
                String mediaId = mediaDescription2.getMediaId();
                CharSequence title = mediaDescription2.getTitle();
                CharSequence subtitle = mediaDescription2.getSubtitle();
                CharSequence description = mediaDescription2.getDescription();
                Bitmap iconBitmap = mediaDescription2.getIconBitmap();
                Uri iconUri = mediaDescription2.getIconUri();
                Bundle extras = mediaDescription2.getExtras();
                if (extras != null) {
                    z.Z(extras);
                    try {
                        extras.isEmpty();
                    } catch (BadParcelableException unused) {
                        Log.e("MediaSessionCompat", "Could not unparcel the data.");
                        extras = null;
                    }
                    break;
                } else {
                    extras = null;
                }
                if (extras != null) {
                    extras = new Bundle(extras);
                }
                if (extras != null) {
                    Uri uri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
                    if (uri == null) {
                        bundle2 = extras;
                        mediaUri = uri;
                    } else if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                        bundle2 = null;
                        mediaUri = uri;
                    } else {
                        extras.remove("android.support.v4.media.description.MEDIA_URI");
                        extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                        bundle2 = extras;
                        mediaUri = uri;
                    }
                } else {
                    bundle2 = extras;
                }
                if (mediaUri == null) {
                    mediaUri = mediaDescription2.getMediaUri();
                }
                n nVar = new n(mediaId, title, subtitle, description, iconBitmap, iconUri, bundle2, mediaUri);
                nVar.C = mediaDescription2;
                return nVar;
            case 18:
                return new o(parcel);
            case 19:
                return new w(parcel);
            case 20:
                x xVar = new x();
                xVar.f5861u = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                return xVar;
            case 21:
                MediaSession.Token token = (MediaSession.Token) parcel.readParcelable(null);
                token.getClass();
                return new y(token, null);
            case 22:
                f0 f0Var = new f0();
                f0Var.f5801u = parcel.readInt();
                f0Var.f5803w = parcel.readInt();
                f0Var.f5804x = parcel.readInt();
                f0Var.f5805y = parcel.readInt();
                f0Var.f5802v = parcel.readInt();
                return f0Var;
            case 23:
                return new h0(parcel);
            case 24:
                return new g0(parcel);
            case 25:
                return new i0(parcel.readInt(), parcel.readFloat());
            case 26:
                return new ParcelImpl(parcel);
            case 27:
                int iV = q1.c.V(parcel);
                long jK = 0;
                long jK2 = 0;
                long jK3 = 0;
                boolean zI = false;
                String strU = null;
                String strU2 = null;
                e4 e4Var = null;
                String strU3 = null;
                v vVar = null;
                v vVar2 = null;
                v vVar3 = null;
                while (parcel.dataPosition() < iV) {
                    int i10 = parcel.readInt();
                    switch ((char) i10) {
                        case 2:
                            strU = q1.c.u(parcel, i10);
                            break;
                        case 3:
                            strU2 = q1.c.u(parcel, i10);
                            break;
                        case j.LONG_FIELD_NUMBER /* 4 */:
                            e4Var = (e4) q1.c.t(parcel, i10, e4.CREATOR);
                            break;
                        case j.STRING_FIELD_NUMBER /* 5 */:
                            jK = q1.c.K(parcel, i10);
                            break;
                        case j.STRING_SET_FIELD_NUMBER /* 6 */:
                            zI = q1.c.I(parcel, i10);
                            break;
                        case j.DOUBLE_FIELD_NUMBER /* 7 */:
                            strU3 = q1.c.u(parcel, i10);
                            break;
                        case '\b':
                            vVar = (v) q1.c.t(parcel, i10, v.CREATOR);
                            break;
                        case '\t':
                            jK2 = q1.c.K(parcel, i10);
                            break;
                        case '\n':
                            vVar2 = (v) q1.c.t(parcel, i10, v.CREATOR);
                            break;
                        case 11:
                            jK3 = q1.c.K(parcel, i10);
                            break;
                        case '\f':
                            vVar3 = (v) q1.c.t(parcel, i10, v.CREATOR);
                            break;
                        default:
                            q1.c.R(parcel, i10);
                            break;
                    }
                }
                q1.c.z(parcel, iV);
                return new k8.d(strU, strU2, e4Var, jK, zI, strU3, vVar, jK2, vVar2, jK3, vVar3);
            case 28:
                int iV2 = q1.c.V(parcel);
                while (parcel.dataPosition() < iV2) {
                    int i11 = parcel.readInt();
                    if (((char) i11) != 1) {
                        q1.c.R(parcel, i11);
                    } else {
                        bundleS2 = q1.c.s(parcel, i11);
                    }
                }
                q1.c.z(parcel, iV2);
                return new g(bundleS2);
            default:
                int iV3 = q1.c.V(parcel);
                while (parcel.dataPosition() < iV3) {
                    int i12 = parcel.readInt();
                    if (((char) i12) != 2) {
                        q1.c.R(parcel, i12);
                    } else {
                        bundleS = q1.c.s(parcel, i12);
                    }
                }
                q1.c.z(parcel, iV3);
                return new u(bundleS);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f633a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new c[i];
            case 1:
                return new MediaBrowserCompat$MediaItem[i];
            case 2:
                return new MediaDescriptionCompat[i];
            case 3:
                return new MediaMetadataCompat[i];
            case j.LONG_FIELD_NUMBER /* 4 */:
                return new RatingCompat[i];
            case j.STRING_FIELD_NUMBER /* 5 */:
                return new androidx.fragment.app.b[i];
            case j.STRING_SET_FIELD_NUMBER /* 6 */:
                return new androidx.fragment.app.c[i];
            case j.DOUBLE_FIELD_NUMBER /* 7 */:
                return new k0[i];
            case 8:
                return new o0[i];
            case 9:
                return new s0[i];
            case 10:
                return new b.d[i];
            case 11:
                return new com.google.android.material.datepicker.b[i];
            case 12:
                return new com.google.android.material.datepicker.d[i];
            case 13:
                return new q[i];
            case 14:
                return new e.a[i];
            case 15:
                return new e.h[i];
            case 16:
                return new k[i];
            case 17:
                return new n[i];
            case 18:
                return new o[i];
            case 19:
                return new w[i];
            case 20:
                return new x[i];
            case 21:
                return new y[i];
            case 22:
                return new f0[i];
            case 23:
                return new h0[i];
            case 24:
                return new g0[i];
            case 25:
                return new i0[i];
            case 26:
                return new ParcelImpl[i];
            case 27:
                return new k8.d[i];
            case 28:
                return new g[i];
            default:
                return new u[i];
        }
    }
}
