package app.cricfy.tv.services;

import a7.h;
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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.fragment.app.f1;
import androidx.media3.ui.PlayerView;
import app.cricfy.tv.app.ProApplication;
import d6.a;
import d6.b;
import d6.c;
import d6.k;
import g2.g0;
import h0.m;
import java.util.ArrayList;
import java.util.Random;
import nc.p;
import q5.j;
import u5.d;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class FloatingPlayer extends Service {
    public static volatile FloatingPlayer F;
    public k A;
    public View B;
    public p C;
    public d D;
    public boolean E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public WindowManager f1575v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f1576w = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayList f1577x = new ArrayList();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Random f1578y = new Random();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ProApplication f1579z;

    public final void a() {
        this.A.f(this.f1579z.f1568v, this.C, this.D, false);
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f1576w;
            if (i >= arrayList.size()) {
                return;
            }
            View view = (View) arrayList.get(i);
            if (view != null) {
                view.setVisibility(0);
            }
            k kVar = (k) this.f1577x.get(i);
            if (kVar != null) {
                p pVar = kVar.f3424c;
                if (pVar != null) {
                    ((ProgressBar) pVar.f9071c).setVisibility(kVar.f3434o ? 0 : 8);
                }
                if (!kVar.f3439t && !kVar.f3440u) {
                    kVar.c();
                }
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
        F = this;
        ProApplication proApplication = (ProApplication) getApplication();
        this.f1579z = proApplication;
        proApplication.f1570x = new f1(2, this);
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
        g0 g0Var;
        super.onDestroy();
        for (int i = 0; i < this.f1576w.size(); i++) {
            View view = (View) this.f1576w.get(i);
            if (view != null) {
                this.f1575v.removeView(view);
            }
            k kVar = (k) this.f1577x.get(i);
            if (kVar != null && (g0Var = kVar.f) != null) {
                g0Var.C1();
                kVar.f = null;
                kVar.f3424c = null;
                kVar.f3425d = null;
                kVar.f3426e = null;
                kVar.f3427g = null;
            }
        }
        this.f1577x.clear();
        this.f1576w.clear();
        F = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26 && !this.E) {
            m mVar = new m(this, "floating_player_channel");
            mVar.f5453e = m.b("Floating Player");
            mVar.f = m.b("Player is running in background");
            mVar.f5465s.icon = j.ic_stat_notification;
            mVar.c(2, true);
            mVar.f5456j = 0;
            startForeground(1001, mVar.a());
            this.E = true;
        }
        if (intent != null) {
            this.f1575v = (WindowManager) getSystemService("window");
            ArrayList arrayList = this.f1576w;
            int size = arrayList.size();
            int i12 = com.bumptech.glide.d.t(getApplicationContext()).getInt("floatings", 0);
            ArrayList arrayList2 = this.f1577x;
            if (size < i12) {
                p pVarS = p.s(LayoutInflater.from(new ContextThemeWrapper(this, k9.k.Theme_Material3_DayNight_NoActionBar)));
                PlayerView playerView = (PlayerView) pVarS.f9070b;
                RelativeLayout relativeLayout = (RelativeLayout) pVarS.f9069a;
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams((int) TypedValue.applyDimension(1, 250, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 160, getResources().getDisplayMetrics()), i11 >= 26 ? 2038 : 2002, 8, -3);
                layoutParams.gravity = 8388659;
                Random random = this.f1578y;
                layoutParams.x = random.nextInt(400);
                layoutParams.y = random.nextInt(800);
                d dVarA = d.a(playerView.findViewById(q5.k.player_controls));
                k kVar = new k(this.f1579z.f1568v, pVarS, dVarA, intent);
                kVar.f3423b = new a(this, kVar, relativeLayout, pVarS, dVarA);
                dVarA.f12246d.setOnClickListener(new b(this, kVar, relativeLayout, 0));
                c cVar = new c(this, layoutParams, relativeLayout, pVarS);
                relativeLayout.setOnTouchListener(cVar);
                playerView.setOnTouchListener(cVar);
                this.f1575v.addView(relativeLayout, layoutParams);
                arrayList.add(relativeLayout);
                arrayList2.add(kVar);
                return 1;
            }
            ((k) arrayList2.get(arrayList.size() - 1)).a(intent);
        }
        return 1;
    }
}
