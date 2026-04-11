package l5;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f7859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap f7860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f7861e;
    public HashMap f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f7862g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s.j f7863h;
    public s.g i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f7864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Rect f7865k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f7866l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f7867m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f7868n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7869o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f7857a = new d0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f7858b = new HashSet();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f7870p = 0;

    public final void a(String str) {
        x5.b.b(str);
        this.f7858b.add(str);
    }

    public final float b() {
        return (long) (((this.f7867m - this.f7866l) / this.f7868n) * 1000.0f);
    }

    public final Map c() {
        float fC = x5.g.c();
        if (fC != this.f7861e) {
            for (Map.Entry entry : this.f7860d.entrySet()) {
                HashMap map = this.f7860d;
                String str = (String) entry.getKey();
                x xVar = (x) entry.getValue();
                float f = this.f7861e / fC;
                int i = (int) (xVar.f7924a * f);
                int i10 = (int) (xVar.f7925b * f);
                x xVar2 = new x(i, i10, xVar.f7926c, xVar.f7927d, xVar.f7928e);
                Bitmap bitmap = xVar.f;
                if (bitmap != null) {
                    xVar2.f = Bitmap.createScaledBitmap(bitmap, i, i10, true);
                }
                map.put(str, xVar2);
            }
        }
        this.f7861e = fC;
        return this.f7860d;
    }

    public final q5.h d(String str) {
        int size = this.f7862g.size();
        for (int i = 0; i < size; i++) {
            q5.h hVar = (q5.h) this.f7862g.get(i);
            String str2 = hVar.f11015a;
            if (str2.equalsIgnoreCase(str) || (str2.endsWith("\r") && str2.substring(0, str2.length() - 1).equalsIgnoreCase(str))) {
                return hVar;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("LottieComposition:\n");
        ArrayList arrayList = this.f7864j;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            sb2.append(((t5.e) obj).a("\t"));
        }
        return sb2.toString();
    }
}
