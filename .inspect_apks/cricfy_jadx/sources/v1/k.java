package v1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new j(1);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12795v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final UUID f12796w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f12797x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f12798y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final byte[] f12799z;

    public k(UUID uuid, String str, String str2, byte[] bArr) {
        uuid.getClass();
        this.f12796w = uuid;
        this.f12797x = str;
        str2.getClass();
        this.f12798y = m0.p(str2);
        this.f12799z = bArr;
    }

    public final boolean a(UUID uuid) {
        UUID uuid2 = f.f12657a;
        UUID uuid3 = this.f12796w;
        return uuid2.equals(uuid3) || uuid.equals(uuid3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        k kVar = (k) obj;
        return Objects.equals(this.f12797x, kVar.f12797x) && Objects.equals(this.f12798y, kVar.f12798y) && Objects.equals(this.f12796w, kVar.f12796w) && Arrays.equals(this.f12799z, kVar.f12799z);
    }

    public final int hashCode() {
        if (this.f12795v == 0) {
            int iHashCode = this.f12796w.hashCode() * 31;
            String str = this.f12797x;
            this.f12795v = Arrays.hashCode(this.f12799z) + l0.e.e((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.f12798y);
        }
        return this.f12795v;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        UUID uuid = this.f12796w;
        parcel.writeLong(uuid.getMostSignificantBits());
        parcel.writeLong(uuid.getLeastSignificantBits());
        parcel.writeString(this.f12797x);
        parcel.writeString(this.f12798y);
        parcel.writeByteArray(this.f12799z);
    }

    public k(Parcel parcel) {
        this.f12796w = new UUID(parcel.readLong(), parcel.readLong());
        this.f12797x = parcel.readString();
        String string = parcel.readString();
        int i = y1.a0.f14551a;
        this.f12798y = string;
        this.f12799z = parcel.createByteArray();
    }
}
