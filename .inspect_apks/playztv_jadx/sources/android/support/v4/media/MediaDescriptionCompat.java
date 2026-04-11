package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a9.b(2);
    public final Bundle A;
    public final Uri B;
    public MediaDescription C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f821u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CharSequence f822v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CharSequence f823w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CharSequence f824x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Bitmap f825y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Uri f826z;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f821u = str;
        this.f822v = charSequence;
        this.f823w = charSequence2;
        this.f824x = charSequence3;
        this.f825y = bitmap;
        this.f826z = uri;
        this.A = bundle;
        this.B = uri2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f822v) + ", " + ((Object) this.f823w) + ", " + ((Object) this.f824x);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        MediaDescription mediaDescriptionA = this.C;
        if (mediaDescriptionA == null) {
            MediaDescription.Builder builderB = a.b();
            a.n(builderB, this.f821u);
            a.p(builderB, this.f822v);
            a.o(builderB, this.f823w);
            a.j(builderB, this.f824x);
            a.l(builderB, this.f825y);
            a.m(builderB, this.f826z);
            a.k(builderB, this.A);
            b.b(builderB, this.B);
            mediaDescriptionA = a.a(builderB);
            this.C = mediaDescriptionA;
        }
        mediaDescriptionA.writeToParcel(parcel, i);
    }
}
