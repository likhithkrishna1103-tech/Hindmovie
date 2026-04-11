package h4;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements Parcelable {
    public static final Parcelable.Creator<n> CREATOR = new a9.b(17);
    public final Bundle A;
    public final Uri B;
    public MediaDescription C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f5829u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CharSequence f5830v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CharSequence f5831w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CharSequence f5832x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Bitmap f5833y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Uri f5834z;

    public n(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f5829u = str;
        this.f5830v = charSequence;
        this.f5831w = charSequence2;
        this.f5832x = charSequence3;
        this.f5833y = bitmap;
        this.f5834z = uri;
        this.A = bundle;
        this.B = uri2;
    }

    public final MediaDescription a() {
        MediaDescription mediaDescription = this.C;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        MediaDescription.Builder builder = new MediaDescription.Builder();
        builder.setMediaId(this.f5829u);
        builder.setTitle(this.f5830v);
        builder.setSubtitle(this.f5831w);
        builder.setDescription(this.f5832x);
        builder.setIconBitmap(this.f5833y);
        builder.setIconUri(this.f5834z);
        builder.setExtras(this.A);
        builder.setMediaUri(this.B);
        MediaDescription mediaDescriptionBuild = builder.build();
        this.C = mediaDescriptionBuild;
        return mediaDescriptionBuild;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f5830v) + ", " + ((Object) this.f5831w) + ", " + ((Object) this.f5832x);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        a().writeToParcel(parcel, i);
    }
}
