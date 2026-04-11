package a7;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import l4.c0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Bitmap.Config[] f331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Bitmap.Config[] f332e;
    public static final Bitmap.Config[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Bitmap.Config[] f333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Bitmap.Config[] f334h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f335a = new f(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f336b = new c0(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f337c = new HashMap();

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f331d = configArr;
        f332e = configArr;
        f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f333g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f334h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
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
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + c(s7.m.c(bitmap), bitmap.getConfig()) + ", this: " + this);
    }

    public final Bitmap b(int i, int i10, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int iD = s7.m.d(config) * i * i10;
        f fVar = this.f335a;
        j jVarN1 = (j) ((ArrayDeque) fVar.f307w).poll();
        if (jVarN1 == null) {
            jVarN1 = fVar.n1();
        }
        l lVar = (l) jVarN1;
        lVar.f329b = iD;
        lVar.f330c = config;
        int i11 = 0;
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
            int i12 = k.f327a[config.ordinal()];
            configArr = i12 != 1 ? i12 != 2 ? i12 != 3 ? i12 != 4 ? new Bitmap.Config[]{config} : f334h : f333g : f : f331d;
        } else {
            configArr = f332e;
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
                fVar.e1(lVar);
                int iIntValue = num.intValue();
                j jVarN12 = (j) ((ArrayDeque) fVar.f307w).poll();
                if (jVarN12 == null) {
                    jVarN12 = fVar.n1();
                }
                lVar = (l) jVarN12;
                lVar.f329b = iIntValue;
                lVar.f330c = config2;
            }
        }
        Bitmap bitmap = (Bitmap) this.f336b.L(lVar);
        if (bitmap != null) {
            a(Integer.valueOf(lVar.f329b), bitmap);
            bitmap.reconfigure(i, i10, config);
        }
        return bitmap;
    }

    public final NavigableMap d(Bitmap.Config config) {
        HashMap map = this.f337c;
        NavigableMap navigableMap = (NavigableMap) map.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        map.put(config, treeMap);
        return treeMap;
    }

    public final void e(Bitmap bitmap) {
        int iC = s7.m.c(bitmap);
        Bitmap.Config config = bitmap.getConfig();
        f fVar = this.f335a;
        j jVarN1 = (j) ((ArrayDeque) fVar.f307w).poll();
        if (jVarN1 == null) {
            jVarN1 = fVar.n1();
        }
        l lVar = (l) jVarN1;
        lVar.f329b = iC;
        lVar.f330c = config;
        this.f336b.S(lVar, bitmap);
        NavigableMap navigableMapD = d(bitmap.getConfig());
        Integer num = (Integer) navigableMapD.get(Integer.valueOf(lVar.f329b));
        navigableMapD.put(Integer.valueOf(lVar.f329b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public final String toString() {
        StringBuilder sbB = y.e.b("SizeConfigStrategy{groupedMap=");
        sbB.append(this.f336b);
        sbB.append(", sortedSizes=(");
        HashMap map = this.f337c;
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
