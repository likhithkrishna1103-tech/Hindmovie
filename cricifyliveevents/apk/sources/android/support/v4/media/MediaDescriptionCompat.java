package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a(1);
    public final Uri A;
    public final Bundle B;
    public final Uri C;
    public MediaDescription D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f478v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CharSequence f479w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CharSequence f480x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final CharSequence f481y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Bitmap f482z;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f478v = str;
        this.f479w = charSequence;
        this.f480x = charSequence2;
        this.f481y = charSequence3;
        this.f482z = bitmap;
        this.A = uri;
        this.B = bundle;
        this.C = uri2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f479w) + ", " + ((Object) this.f480x) + ", " + ((Object) this.f481y);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        MediaDescription mediaDescriptionA = this.D;
        if (mediaDescriptionA == null) {
            MediaDescription.Builder builderB = b.b();
            b.n(builderB, this.f478v);
            b.p(builderB, this.f479w);
            b.o(builderB, this.f480x);
            b.j(builderB, this.f481y);
            b.l(builderB, this.f482z);
            b.m(builderB, this.A);
            b.k(builderB, this.B);
            c.b(builderB, this.C);
            mediaDescriptionA = b.a(builderB);
            this.D = mediaDescriptionA;
        }
        mediaDescriptionA.writeToParcel(parcel, i);
    }
}
