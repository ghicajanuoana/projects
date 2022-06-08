package presentation;

import bll.model.DeliveryService;

public interface Observer {
	void update(DeliveryService delivery);
}
