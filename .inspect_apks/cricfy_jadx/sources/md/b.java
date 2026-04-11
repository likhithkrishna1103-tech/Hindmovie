package md;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable, Serializable {
    public static final a CREATOR = new a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f8419v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f8420w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f8421x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f8422y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f8423z = -1;

    public final void a(int i) {
        this.f8420w = i;
    }

    public final void b(int i) {
        this.f8419v = i;
    }

    public final void c(long j4) {
        this.f8423z = j4;
    }

    public final void d(long j4) {
        this.f8422y = j4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e(long j4) {
        this.f8421x = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!b.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        ge.i.c(obj, "null cannot be cast to non-null type com.tonyodev.fetch2core.DownloadBlockInfo");
        b bVar = (b) obj;
        return this.f8419v == bVar.f8419v && this.f8420w == bVar.f8420w && this.f8421x == bVar.f8421x && this.f8422y == bVar.f8422y && this.f8423z == bVar.f8423z;
    }

    public final int hashCode() {
        int i = ((this.f8419v * 31) + this.f8420w) * 31;
        long j4 = this.f8421x;
        int i10 = (i + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j7 = this.f8422y;
        int i11 = (i10 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        long j10 = this.f8423z;
        return i11 + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        int i = this.f8419v;
        int i10 = this.f8420w;
        long j4 = this.f8421x;
        long j7 = this.f8422y;
        long j10 = this.f8423z;
        StringBuilder sbR = q4.a.r(i, i10, "DownloadBlock(downloadId=", ", blockPosition=", ", startByte=");
        sbR.append(j4);
        sbR.append(", endByte=");
        sbR.append(j7);
        sbR.append(", downloadedBytes=");
        return q4.a.p(sbR, j10, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ge.i.e(parcel, "dest");
        parcel.writeInt(this.f8419v);
        parcel.writeInt(this.f8420w);
        parcel.writeLong(this.f8421x);
        parcel.writeLong(this.f8422y);
        parcel.writeLong(this.f8423z);
    }
}
