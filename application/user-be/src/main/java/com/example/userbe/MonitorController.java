package com.example.userbe;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/monitors")
@RestController
public class MonitorController {

  private boolean health = true;

  @GetMapping
  public ResponseEntity<Void> check() {

    if (health) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }
  }

  @GetMapping("/up")
  public void up() {
    this.health = true;
  }

  @GetMapping("/down")
  public void down() {
    this.health = false;
  }
}
