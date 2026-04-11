package l4;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new y5.f(1);
    public final Uri A;
    public final Bundle B;
    public final Uri C;
    public MediaDescription D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f7746v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CharSequence f7747w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CharSequence f7748x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final CharSequence f7749y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Bitmap f7750z;

    public o(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f7746v = str;
        this.f7747w = charSequence;
        this.f7748x = charSequence2;
        this.f7749y = charSequence3;
        this.f7750z = bitmap;
        this.A = uri;
        this.B = bundle;
        this.C = uri2;
    }

    public final MediaDescription a() {
        MediaDescription mediaDescription = this.D;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        MediaDescription.Builder builder = new MediaDescription.Builder();
        builder.setMediaId(this.f7746v);
        builder.setTitle(this.f7747w);
        builder.setSubtitle(this.f7748x);
        builder.setDescription(this.f7749y);
        builder.setIconBitmap(this.f7750z);
        builder.setIconUri(this.A);
        builder.setExtras(this.B);
        builder.setMediaUri(this.C);
        MediaDescription mediaDescriptionBuild = builder.build();
        this.D = mediaDescriptionBuild;
        return mediaDescriptionBuild;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f7747w) + ", " + ((Object) this.f7748x) + ", " + ((Object) this.f7749y);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        a().writeToParcel(parcel, i);
    }
}
