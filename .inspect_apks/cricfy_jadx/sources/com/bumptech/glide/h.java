package com.bumptech.glide;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final h f2209v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final h f2210w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final h f2211x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final h f2212y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ h[] f2213z;

    static {
        h hVar = new h("IMMEDIATE", 0);
        f2209v = hVar;
        h hVar2 = new h("HIGH", 1);
        f2210w = hVar2;
        h hVar3 = new h("NORMAL", 2);
        f2211x = hVar3;
        h hVar4 = new h("LOW", 3);
        f2212y = hVar4;
        f2213z = new h[]{hVar, hVar2, hVar3, hVar4};
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f2213z.clone();
    }
}
