package com.playz.tv.app;

import android.app.Application;
import com.playz.tv.activities.LandscapeActivity;
import ga.g;
import h.j;
import java.util.List;
import jc.d;
import nc.c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class ProApplication extends Application {
    public static ProApplication I;
    public List A;
    public List B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public int H;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public j f3677u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LandscapeActivity f3678v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c f3679w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public d f3680x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List f3681y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List f3682z;

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
        I = this;
        g.f(getApplicationContext());
    }
}
