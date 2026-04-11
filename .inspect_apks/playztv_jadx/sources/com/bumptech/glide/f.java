package com.bumptech.glide;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final f f2780u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final f f2781v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final f f2782w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final f f2783x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ f[] f2784y;

    static {
        f fVar = new f("IMMEDIATE", 0);
        f2780u = fVar;
        f fVar2 = new f("HIGH", 1);
        f2781v = fVar2;
        f fVar3 = new f("NORMAL", 2);
        f2782w = fVar3;
        f fVar4 = new f("LOW", 3);
        f2783x = fVar4;
        f2784y = new f[]{fVar, fVar2, fVar3, fVar4};
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f2784y.clone();
    }
}
