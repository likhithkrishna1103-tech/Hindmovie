package g6;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f5088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap f5089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f5090e;
    public HashMap f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f5091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public v.l f5092h;
    public v.h i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f5093j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Rect f5094k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f5095l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f5096m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f5097n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f5098o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f5086a = new e0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f5087b = new HashSet();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f5099p = 0;

    public final void a(String str) {
        s6.c.b(str);
        this.f5087b.add(str);
    }

    public final float b() {
        return (long) (((this.f5096m - this.f5095l) / this.f5097n) * 1000.0f);
    }

    public final Map c() {
        float fC = s6.i.c();
        if (fC != this.f5090e) {
            for (Map.Entry entry : this.f5089d.entrySet()) {
                HashMap map = this.f5089d;
                String str = (String) entry.getKey();
                y yVar = (y) entry.getValue();
                float f = this.f5090e / fC;
                int i = (int) (yVar.f5159a * f);
                int i10 = (int) (yVar.f5160b * f);
                y yVar2 = new y(i, i10, yVar.f5161c, yVar.f5162d, yVar.f5163e);
                Bitmap bitmap = yVar.f;
                if (bitmap != null) {
                    yVar2.f = Bitmap.createScaledBitmap(bitmap, i, i10, true);
                }
                map.put(str, yVar2);
            }
        }
        this.f5090e = fC;
        return this.f5089d;
    }

    public final l6.h d(String str) {
        int size = this.f5091g.size();
        for (int i = 0; i < size; i++) {
            l6.h hVar = (l6.h) this.f5091g.get(i);
            String str2 = hVar.f7862a;
            if (str2.equalsIgnoreCase(str) || (str2.endsWith("\r") && str2.substring(0, str2.length() - 1).equalsIgnoreCase(str))) {
                return hVar;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        ArrayList arrayList = this.f5093j;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            sb.append(((o6.d) obj).a("\t"));
        }
        return sb.toString();
    }
}
