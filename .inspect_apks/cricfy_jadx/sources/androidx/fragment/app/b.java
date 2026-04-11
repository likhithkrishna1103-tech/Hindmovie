package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new android.support.v4.media.a(4);
    public final String A;
    public final int B;
    public final int C;
    public final CharSequence D;
    public final int E;
    public final CharSequence F;
    public final ArrayList G;
    public final ArrayList H;
    public final boolean I;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int[] f937v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f938w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f939x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f940y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f941z;

    public b(a aVar) {
        int size = aVar.f911a.size();
        this.f937v = new int[size * 6];
        if (!aVar.f916g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f938w = new ArrayList(size);
        this.f939x = new int[size];
        this.f940y = new int[size];
        int i = 0;
        for (int i10 = 0; i10 < size; i10++) {
            a1 a1Var = (a1) aVar.f911a.get(i10);
            int i11 = i + 1;
            this.f937v[i] = a1Var.f930a;
            ArrayList arrayList = this.f938w;
            y yVar = a1Var.f931b;
            arrayList.add(yVar != null ? yVar.A : null);
            int[] iArr = this.f937v;
            iArr[i11] = a1Var.f932c ? 1 : 0;
            iArr[i + 2] = a1Var.f933d;
            iArr[i + 3] = a1Var.f934e;
            int i12 = i + 5;
            iArr[i + 4] = a1Var.f;
            i += 6;
            iArr[i12] = a1Var.f935g;
            this.f939x[i10] = a1Var.f936h.ordinal();
            this.f940y[i10] = a1Var.i.ordinal();
        }
        this.f941z = aVar.f;
        this.A = aVar.i;
        this.B = aVar.f927s;
        this.C = aVar.f918j;
        this.D = aVar.f919k;
        this.E = aVar.f920l;
        this.F = aVar.f921m;
        this.G = aVar.f922n;
        this.H = aVar.f923o;
        this.I = aVar.f924p;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f937v);
        parcel.writeStringList(this.f938w);
        parcel.writeIntArray(this.f939x);
        parcel.writeIntArray(this.f940y);
        parcel.writeInt(this.f941z);
        parcel.writeString(this.A);
        parcel.writeInt(this.B);
        parcel.writeInt(this.C);
        TextUtils.writeToParcel(this.D, parcel, 0);
        parcel.writeInt(this.E);
        TextUtils.writeToParcel(this.F, parcel, 0);
        parcel.writeStringList(this.G);
        parcel.writeStringList(this.H);
        parcel.writeInt(this.I ? 1 : 0);
    }

    public b(Parcel parcel) {
        this.f937v = parcel.createIntArray();
        this.f938w = parcel.createStringArrayList();
        this.f939x = parcel.createIntArray();
        this.f940y = parcel.createIntArray();
        this.f941z = parcel.readInt();
        this.A = parcel.readString();
        this.B = parcel.readInt();
        this.C = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.D = (CharSequence) creator.createFromParcel(parcel);
        this.E = parcel.readInt();
        this.F = (CharSequence) creator.createFromParcel(parcel);
        this.G = parcel.createStringArrayList();
        this.H = parcel.createStringArrayList();
        this.I = parcel.readInt() != 0;
    }
}
