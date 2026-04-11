package com.playz.tv.services;

import a2.o0;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.media3.ui.PlayerView;
import b2.g;
import com.playz.tv.app.ProApplication;
import e0.m;
import gc.j;
import java.util.ArrayList;
import java.util.Random;
import kc.e;
import lb.h;
import nc.c;
import p8.k;
import tc.a;
import uc.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class FloatingPlayer extends Service {
    public static volatile FloatingPlayer E;
    public View A;
    public g B;
    public e C;
    public boolean D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public WindowManager f3685u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f3686v = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f3687w = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Random f3688x = new Random();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ProApplication f3689y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public tc.g f3690z;

    public final void a() {
        this.f3690z.h(this.f3689y.f3677u, this.B, this.C, false);
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f3686v;
            if (i >= arrayList.size()) {
                return;
            }
            View view = (View) arrayList.get(i);
            if (view != null) {
                view.setVisibility(0);
            }
            tc.g gVar = (tc.g) this.f3687w.get(i);
            if (gVar != null && gVar.c()) {
                gVar.e();
            }
            i++;
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        E = this;
        ProApplication proApplication = (ProApplication) getApplication();
        this.f3689y = proApplication;
        proApplication.f3679w = new c(12, this);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannelB = h.b();
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannelB);
            }
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        o0 o0Var;
        super.onDestroy();
        for (int i = 0; i < this.f3686v.size(); i++) {
            View view = (View) this.f3686v.get(i);
            if (view != null) {
                this.f3685u.removeView(view);
            }
            tc.g gVar = (tc.g) this.f3687w.get(i);
            if (gVar != null && (o0Var = gVar.f) != null) {
                o0Var.F1();
                gVar.f = null;
                gVar.f12465c = null;
                gVar.f12466d = null;
                gVar.f12467e = null;
                gVar.f12468g = null;
            }
        }
        this.f3687w.clear();
        this.f3686v.clear();
        E = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26 && !this.D) {
            m mVar = new m(this, "floating_player_channel");
            mVar.f4260e = m.b("Floating Player");
            mVar.f = m.b("Player is running in background");
            mVar.f4272s.icon = gc.m.ic_launcher;
            mVar.c(2, true);
            mVar.f4263j = 0;
            startForeground(1001, mVar.a());
            this.D = true;
        }
        if (intent != null) {
            this.f3685u = (WindowManager) getSystemService("window");
            ArrayList arrayList = this.f3686v;
            int size = arrayList.size();
            int i12 = b.f(getApplicationContext()).getInt("floatings", 0);
            ArrayList arrayList2 = this.f3687w;
            if (size < i12) {
                g gVarP = g.p(LayoutInflater.from(new ContextThemeWrapper(this, k.Theme_Material3_DayNight_NoActionBar)));
                PlayerView playerView = (PlayerView) gVarP.f1739d;
                RelativeLayout relativeLayout = (RelativeLayout) gVarP.f1737b;
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams((int) TypedValue.applyDimension(1, 250, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 160, getResources().getDisplayMetrics()), i11 >= 26 ? 2038 : 2002, 8, -3);
                layoutParams.gravity = 8388659;
                Random random = this.f3688x;
                layoutParams.x = random.nextInt(400);
                layoutParams.y = random.nextInt(800);
                e eVarA = e.a(playerView.findViewById(j.player_controls));
                tc.g gVar = new tc.g(this.f3689y.f3677u, gVarP, eVarA, intent);
                gVar.f12464b = new a(this, gVar, relativeLayout, gVarP, eVarA);
                eVarA.f7655g.setOnClickListener(new ic.a(this, gVar, relativeLayout, 3));
                tc.b bVar = new tc.b(this, layoutParams, relativeLayout, gVarP);
                relativeLayout.setOnTouchListener(bVar);
                playerView.setOnTouchListener(bVar);
                this.f3685u.addView(relativeLayout, layoutParams);
                arrayList.add(relativeLayout);
                arrayList2.add(gVar);
                return 1;
            }
            ((tc.g) arrayList2.get(arrayList.size() - 1)).a(intent);
        }
        return 1;
    }
}
