package hf;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Drawable f5961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f5962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5963e;

    public b(String str, String str2, Drawable drawable) {
        RectF rectF = new RectF();
        this.f5959a = str;
        this.f5960b = str2;
        this.f5961c = drawable;
        this.f5962d = rectF;
        this.f5963e = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return ge.i.a(this.f5959a, bVar.f5959a) && ge.i.a(this.f5960b, bVar.f5960b) && ge.i.a(this.f5961c, bVar.f5961c) && ge.i.a(this.f5962d, bVar.f5962d) && this.f5963e == bVar.f5963e;
    }

    public final int hashCode() {
        String str = this.f5959a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f5960b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Drawable drawable = this.f5961c;
        int iHashCode3 = (iHashCode2 + (drawable != null ? drawable.hashCode() : 0)) * 31;
        RectF rectF = this.f5962d;
        return ((iHashCode3 + (rectF != null ? rectF.hashCode() : 0)) * 31) + this.f5963e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BottomBarItem(title=");
        sb.append(this.f5959a);
        sb.append(", contentDescription=");
        sb.append(this.f5960b);
        sb.append(", icon=");
        sb.append(this.f5961c);
        sb.append(", rect=");
        sb.append(this.f5962d);
        sb.append(", alpha=");
        return q4.a.o(sb, this.f5963e, ")");
    }
}
