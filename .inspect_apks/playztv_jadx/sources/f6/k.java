package f6;

import android.graphics.Bitmap;
import android.os.Build;
import h4.z;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import x6.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Bitmap.Config[] f4782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Bitmap.Config[] f4783e;
    public static final Bitmap.Config[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Bitmap.Config[] f4784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Bitmap.Config[] f4785h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f4786a = new e(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f4787b = new z(14);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f4788c = new HashMap();

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f4782d = configArr;
        f4783e = configArr;
        f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f4784g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f4785h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String c(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    public final void a(Integer num, Bitmap bitmap) {
        NavigableMap navigableMapD = d(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapD.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapD.remove(num);
                return;
            } else {
                navigableMapD.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + c(m.c(bitmap), bitmap.getConfig()) + ", this: " + this);
    }

    public final Bitmap b(int i, int i10, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int iD = m.d(config) * i * i10;
        e eVar = this.f4786a;
        h hVarQ1 = (h) ((ArrayDeque) eVar.f2454v).poll();
        if (hVarQ1 == null) {
            hVarQ1 = eVar.q1();
        }
        j jVar = (j) hVarQ1;
        jVar.f4780b = iD;
        jVar.f4781c = config;
        int i11 = 0;
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
            int i12 = i.f4778a[config.ordinal()];
            configArr = i12 != 1 ? i12 != 2 ? i12 != 3 ? i12 != 4 ? new Bitmap.Config[]{config} : f4785h : f4784g : f : f4782d;
        } else {
            configArr = f4783e;
        }
        int length = configArr.length;
        while (true) {
            if (i11 >= length) {
                break;
            }
            Bitmap.Config config2 = configArr[i11];
            Integer num = (Integer) d(config2).ceilingKey(Integer.valueOf(iD));
            if (num == null || num.intValue() > iD * 8) {
                i11++;
            } else if (num.intValue() != iD || (config2 != null ? !config2.equals(config) : config != null)) {
                eVar.e1(jVar);
                int iIntValue = num.intValue();
                h hVarQ12 = (h) ((ArrayDeque) eVar.f2454v).poll();
                if (hVarQ12 == null) {
                    hVarQ12 = eVar.q1();
                }
                jVar = (j) hVarQ12;
                jVar.f4780b = iIntValue;
                jVar.f4781c = config2;
            }
        }
        Bitmap bitmap = (Bitmap) this.f4787b.b0(jVar);
        if (bitmap != null) {
            a(Integer.valueOf(jVar.f4780b), bitmap);
            bitmap.reconfigure(i, i10, config);
        }
        return bitmap;
    }

    public final NavigableMap d(Bitmap.Config config) {
        HashMap map = this.f4788c;
        NavigableMap navigableMap = (NavigableMap) map.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        map.put(config, treeMap);
        return treeMap;
    }

    public final void e(Bitmap bitmap) {
        int iC = m.c(bitmap);
        Bitmap.Config config = bitmap.getConfig();
        e eVar = this.f4786a;
        h hVarQ1 = (h) ((ArrayDeque) eVar.f2454v).poll();
        if (hVarQ1 == null) {
            hVarQ1 = eVar.q1();
        }
        j jVar = (j) hVarQ1;
        jVar.f4780b = iC;
        jVar.f4781c = config;
        this.f4787b.g0(jVar, bitmap);
        NavigableMap navigableMapD = d(bitmap.getConfig());
        Integer num = (Integer) navigableMapD.get(Integer.valueOf(jVar.f4780b));
        navigableMapD.put(Integer.valueOf(jVar.f4780b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public final String toString() {
        StringBuilder sbB = v.e.b("SizeConfigStrategy{groupedMap=");
        sbB.append(this.f4787b);
        sbB.append(", sortedSizes=(");
        HashMap map = this.f4788c;
        for (Map.Entry entry : map.entrySet()) {
            sbB.append(entry.getKey());
            sbB.append('[');
            sbB.append(entry.getValue());
            sbB.append("], ");
        }
        if (!map.isEmpty()) {
            sbB.replace(sbB.length() - 2, sbB.length(), "");
        }
        sbB.append(")}");
        return sbB.toString();
    }
}
