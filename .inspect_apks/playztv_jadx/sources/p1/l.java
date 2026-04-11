package p1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new k(1);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f9891u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final UUID f9892v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f9893w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f9894x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final byte[] f9895y;

    public l(UUID uuid, String str, String str2, byte[] bArr) {
        uuid.getClass();
        this.f9892v = uuid;
        this.f9893w = str;
        str2.getClass();
        this.f9894x = m0.p(str2);
        this.f9895y = bArr;
    }

    public final boolean a(UUID uuid) {
        UUID uuid2 = g.f9745a;
        UUID uuid3 = this.f9892v;
        return uuid2.equals(uuid3) || uuid.equals(uuid3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        l lVar = (l) obj;
        return Objects.equals(this.f9893w, lVar.f9893w) && Objects.equals(this.f9894x, lVar.f9894x) && Objects.equals(this.f9892v, lVar.f9892v) && Arrays.equals(this.f9895y, lVar.f9895y);
    }

    public final int hashCode() {
        if (this.f9891u == 0) {
            int iHashCode = this.f9892v.hashCode() * 31;
            String str = this.f9893w;
            this.f9891u = Arrays.hashCode(this.f9895y) + e6.j.h((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.f9894x);
        }
        return this.f9891u;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        UUID uuid = this.f9892v;
        parcel.writeLong(uuid.getMostSignificantBits());
        parcel.writeLong(uuid.getLeastSignificantBits());
        parcel.writeString(this.f9893w);
        parcel.writeString(this.f9894x);
        parcel.writeByteArray(this.f9895y);
    }

    public l(Parcel parcel) {
        this.f9892v = new UUID(parcel.readLong(), parcel.readLong());
        this.f9893w = parcel.readString();
        String string = parcel.readString();
        int i = s1.b0.f11647a;
        this.f9894x = string;
        this.f9895y = parcel.createByteArray();
    }
}
